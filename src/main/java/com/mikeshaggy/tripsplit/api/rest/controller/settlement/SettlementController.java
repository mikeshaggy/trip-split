package com.mikeshaggy.tripsplit.api.rest.controller.settlement;

import com.mikeshaggy.tripsplit.api.dto.settlement.SettlementDTO;
import com.mikeshaggy.tripsplit.service.settlement.SettlementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(SettlementController.BASE_URL)
public class SettlementController {

    public static final String BASE_URL = "/api/settlements";

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @GetMapping
    public ResponseEntity<List<SettlementDTO>> getAllSettlements() {
        return new ResponseEntity<>(settlementService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SettlementDTO> getSettlementById(
            @PathVariable UUID id) {
        return new ResponseEntity<>(settlementService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SettlementDTO> createNewSettlement(
            @Valid @RequestBody SettlementDTO settlementDTO) {
        return new ResponseEntity<>(settlementService.create(settlementDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SettlementDTO> updateSettlement(
            @PathVariable UUID id,
            @Valid @RequestBody SettlementDTO settlementDTO) {
        return new ResponseEntity<>(settlementService.update(id, settlementDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSettlementById(
            @PathVariable UUID id) {
        settlementService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
