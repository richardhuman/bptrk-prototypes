-- ====================
-- RUN AS DEV USER
-- ====================

delete from blood_pressure_readings;

insert into blood_pressure_readings(user_id, created_at, systolic, diastolic, pulse_rate, notes)
values (
    (select id from users where username = 'user3@human.tech'),
    now(),
    130, 90, 67, 'Breakfast'
);

insert into blood_pressure_readings(user_id, created_at, systolic, diastolic, pulse_rate, notes)
values (
    (select id from users where username = 'user3@human.tech'),
    now(),
    125, 85, 60, 'Lunch'
);

insert into blood_pressure_readings(user_id, created_at, systolic, diastolic, pulse_rate, notes)
values (
   (select id from users where username = 'user3@human.tech'),
   now(),
   120, 75, 60, 'Dinner'
);
