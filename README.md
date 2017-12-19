# matillion

Areas of improvement
==================================

1/ Exception handling
2/ Test Driven Development (TDD)

Final SQL query below for a list of people who work in the department "Temp Stockers", are paid hourly, and have an education level of "Graduate Degree";

DO NOT COPY
=================
SELECT full_name, birth_date, hire_date, gender, position_id FROM employee
WHERE department_id = (SELECT d.department_id FROM department d WHERE d.department_description = "Temp Stockers")
AND position_id IN (SELECT position_id FROM position where pay_type = "Hourly")
AND education_level = "Graduate Degree"
ORDER BY full_name ASC;
=================
DO NOT COPY