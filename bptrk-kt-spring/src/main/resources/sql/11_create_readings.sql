-- ====================
-- RUN AS DEV USER
-- ====================

DROP TABLE IF EXISTS blood_pressure_readings;
DROP SEQUENCE IF EXISTS id_blood_pressure_readings_id_seq;

CREATE SEQUENCE id_blood_pressure_readings_id_seq;

CREATE TABLE IF NOT EXISTS blood_pressure_readings (
    id          INTEGER PRIMARY KEY DEFAULT nextval('id_blood_pressure_readings_id_seq'),
    ref         UUID NOT NULL UNIQUE DEFAULT uuid_generate_v4(),
    user_id     INTEGER NOT NULL REFERENCES users(id),

    systolic    INTEGER NOT NULL,
    diastolic   INTEGER NOT NULL,
    pulse_rate  INTEGER NOT NULL,

    notes       TEXT,

    created_at  TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP
);

ALTER SEQUENCE id_blood_pressure_readings_id_seq OWNED BY blood_pressure_readings.id;