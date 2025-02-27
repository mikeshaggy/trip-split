package com.mikeshaggy.tripsplit.service;

import com.mikeshaggy.tripsplit.api.dto.BaseDTO;
import com.mikeshaggy.tripsplit.api.mapper.BaseMapper;
import com.mikeshaggy.tripsplit.dao.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T extends BaseEntity<ID>, ID, D extends BaseDTO<ID>, R extends JpaRepository<T, ID>, M extends BaseMapper<T, D>> {

    protected final R nativeRepository;
    protected final M nativeMapper;

    public BaseService(R nativeRepository, M nativeMapper) {
        this.nativeRepository = nativeRepository;
        this.nativeMapper = nativeMapper;
    }

    public List<D> getAll() {
        return nativeRepository.findAll()
                .stream()
                .map(nativeMapper::toDto)
                .toList();
    }

    public D getById(ID id) {
        return nativeRepository.findById(id)
                .map(nativeMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id %s not found", id)));
    }

    public D create(D dto) {
        T entity = nativeMapper.toEntity(dto);
        T savedEntity = nativeRepository.save(entity);
        return nativeMapper.toDto(savedEntity);
    }

    public D update(ID id, D dto) {
        D entityToUpdate = getById(id);
        dto.setId(id);
        T entity = nativeMapper.toEntity(dto);
        T savedEntity = nativeRepository.save(entity);
        return nativeMapper.toDto(savedEntity);
    }

    public void deleteById(ID id) {
        nativeRepository.deleteById(id);
    }
}
