-- ====================
-- RUN AS DEV USER
-- ====================

DROP TABLE IF EXISTS blood_pressure_reading;
DROP SEQUENCE IF EXISTS id_blood_pressure_reading_id_seq;

CREATE SEQUENCE id_blood_pressure_reading_id_seq;

CREATE TABLE IF NOT EXISTS blood_pressure_reading (
    id          INTEGER PRIMARY KEY DEFAULT nextval('id_blood_pressure_reading_id_seq'),
    ref         UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    user_id     INTEGER NOT NULL REFERENCES "user"(id),

    systolic    INTEGER NOT NULL,
    diastolic   INTEGER NOT NULL,
    pulse_rate  INTEGER NOT NULL,

    notes       TEXT,

    created_at  TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP
);

ALTER SEQUENCE id_blood_pressure_reading_id_seq OWNED BY blood_pressure_reading.id;