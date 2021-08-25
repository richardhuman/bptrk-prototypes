CREATE SEQUENCE idusers_id_seq;

CREATE TABLE IF NOT EXISTS users (
    id          INTEGER PRIMARY KEY DEFAULT nextval('idusers_id_seq'),
    username    VARCHAR(255) NOT NULL
    );

ALTER SEQUENCE idusers_id_seq OWNED BY users.id;