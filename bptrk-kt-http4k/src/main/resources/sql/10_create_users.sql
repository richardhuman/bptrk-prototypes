-- ====================
-- RUN AS DEV USER
-- ====================

-- Add extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


DROP TABLE IF EXISTS "user";
DROP SEQUENCE IF EXISTS id_user_id_seq;

CREATE SEQUENCE id_user_id_seq;

CREATE TABLE IF NOT EXISTS "user" (
    id          INTEGER PRIMARY KEY DEFAULT nextval('id_user_id_seq'),
    ref         UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    username    VARCHAR(255) NOT NULL UNIQUE,
    full_name   VARCHAR(255),
    created_at  TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP
);

ALTER SEQUENCE id_user_id_seq OWNED BY "user".id;