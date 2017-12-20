# matillion

Areas of improvement
==================================

1/ Exception handling
2/ Test Driven Development (TDD)
3/ Improved Menu system - maybe a list of available values

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


Outstanding items

1. Populate department description values from DB
2. Populate pay type from DB
3. Populate education level from DB

4. Check if user input matches first option then proceed
5. Check if user input matches second option then proceed
6. Check if user input matches third option then proceed
7. If none matches then display error message and no SQL is executed