-- ====================
-- RUN AS DEV USER
-- ====================

-- Add extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS id_users_id_seq;

CREATE SEQUENCE id_users_id_seq;

CREATE TABLE IF NOT EXISTS users (
    id          INTEGER PRIMARY KEY DEFAULT nextval('id_users_id_seq'),
    ref         UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    username    VARCHAR(255) NOT NULL UNIQUE,
    full_name   VARCHAR(255),
    created_at  TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP
);

ALTER SEQUENCE id_users_id_seq OWNED BY users.id;