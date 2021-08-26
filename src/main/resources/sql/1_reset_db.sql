-- ====================
-- NB: RUN AS ROOT USER
-- ====================

-- \set db_user dev
-- \set db_password dev -- unused
-- \set db_name bptrk_kt_spring
-- \set db_test_name bptrk_kt_spring_test;

DROP DATABASE IF EXISTS bptrk_kt_spring;
DROP DATABASE IF EXISTS bptrk_kt_spring_test;

DROP USER IF EXISTS bptrk_dev;
DROP USER IF EXISTS bptrk_test;

CREATE USER bptrk_dev WITH PASSWORD 'bptrk_dev' CREATEDB;
CREATE USER bptrk_test WITH PASSWORD 'bptrk_dev' CREATEDB;

CREATE DATABASE bptrk_kt_spring ENCODING='UTF8';
CREATE DATABASE bptrk_kt_spring_test ENCODING='UTF8';

GRANT ALL PRIVILEGES ON DATABASE bptrk_kt_spring TO bptrk_dev;
GRANT ALL PRIVILEGES ON DATABASE bptrk_kt_spring_test TO bptrk_test;
