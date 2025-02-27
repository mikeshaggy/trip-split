create table trips (
    id uuid primary key default gen_random_uuid(),
    name varchar(255) not null,
    start_date date,
    end_date date,
    created_at timestamp not null
);

create table users (
    id uuid primary key default gen_random_uuid(),
    name varchar(255) not null,
    email varchar(255) unique,
    created_at timestamp not null
);

create table trip_participants (
    trip_id uuid references trips(id) on delete cascade,
    user_id uuid references users(id) on delete cascade
);

create table expenses (
    id uuid primary key default gen_random_uuid(),
    amount numeric(10, 2) not null,
    description text not null,
    created_at timestamp not null,
    trip_id uuid references trips(id) on delete cascade,
    user_id uuid references users(id) on delete cascade
);

create table settlements (
    id uuid primary key default gen_random_uuid(),
    trip_id uuid references trips(id) on delete cascade,
    payer_id uuid references users(id) on delete cascade,
    receiver_id uuid references users(id) on delete cascade,
    amount numeric(10, 2) not null
);

insert into trips(id, name, start_date, end_date, created_at) values
                ('2c5d4e5f-3b00-43bd-a138-76e1aefdbf4b','Weekend in Paris', '2024-04-05', '2024-04-07', NOW()),
                ('59bda187-a274-482b-8e9f-65e646547e6d','Road Trip USA', '2024-06-01', '2024-06-16', NOW());

insert into users(id, name, email, created_at) values
                ('2f6d780a-2d67-434a-a967-fedf4da8c637','Mike', 'mike@example.com', NOW()),
                ('9b7fac20-66be-49bf-924c-1c9fb61d0e14','John', 'john@example.com', NOW()),
                ('9adf6989-27f4-41f8-aa9d-fadece94c5ee','Charlie', 'charlie@example.com', NOW());

insert into trip_participants (trip_id, user_id) values
                ((select id from trips where name = 'Weekend in Paris'),
                 (select id from users where name = 'Mike')),
                ((select id from trips where name = 'Weekend in Paris'),
                 (select id from users where name = 'John')),
                ((select id from trips where name = 'Weekend in Paris'),
                 (select id from users where name = 'Charlie'));

insert into expenses (amount, description, trip_id, user_id, created_at) values
    (500, 'Hotel for two nights', (select id from trips where name = 'Weekend in Paris'), (select id from users where name = 'Mike'), NOW()),
    (150, 'Dinner at a restaurant', (select id from trips where name = 'Weekend in Paris'), (select id from users where name = 'John'),NOW()),
    (250, 'Concert tickets', (select id from trips where name = 'Weekend in Paris'), (select id from users where name = 'Charlie'), NOW());

insert into settlements (trip_id, payer_id, receiver_id, amount) values
         ((select id from trips where name = 'Weekend in Paris'), (select id from users where name = 'John'), (select id from users where name = 'Mike'), 150),
         ((select id from trips where name = 'Weekend in Paris'), (select id from users where name = 'Charlie'), (select id from users where name = 'Mike'), 50);
