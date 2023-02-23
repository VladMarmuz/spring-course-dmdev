--liquibase formatted sql

--changeset vmarmuz:1
ALTER TABLE users
    ADD COLUMN created_at TIMESTAMP;

--changeset vmarmuz:2
ALTER TABLE users
    ADD COLUMN modified_at TIMESTAMP;

--changeset vmarmuz:3
ALTER TABLE users
    ADD COLUMN modified_by VARCHAR(32);

--changeset vmarmuz:4
ALTER TABLE users
    ADD COLUMN created_by VARCHAR(32);