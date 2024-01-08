sql.create_employee = INSERT INTO employees (first_name, last_name, email, phone, job_title, salary, is_project_manager,employment_status_id, leave_type_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
sql.update_by_id_employee = UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, job_title=?, salary=?, is_project_manager=?, employment_status_id=?, leave_type_id=?, department_id=? WHERE id_employee=?
sql.delete_by_id_employee = DELETE FROM employees WHERE id_employee=?
sql.find_employee_by_id = SELECT * FROM employees WHERE id_employee=?

sql.create_client = INSERT INTO clients (client_name, client_email, client_phone, client_address) VALUES (?, ?, ?, ?);
sql.update_by_id_client = UPDATE clients SET client_name=?, client_email=?, client_phone=?, client_address=? WHERE id_client=?;
sql.delete_by_id_client = DELETE FROM clients WHERE id_client=?;
sql.find_client_by_id = SELECT * FROM clients WHERE id_client=?;

sql.create_department = INSERT INTO departments (department_name, department_description) VALUES (?, ?);
sql.update_by_id_department = UPDATE departments SET department_name=?, department_description=? WHERE id_department=?;
sql.delete_by_id_department = DELETE FROM departments WHERE id_department=?;
sql.find_department_by_id = SELECT * FROM departments WHERE id_department=?;

sql.create_project = INSERT INTO projects (project_name, project_description, start_date, due_date, priority, status, client_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);
sql.update_by_id_project = UPDATE projects SET project_name=?, project_description=?, start_date=?, due_date=?, priority=?, status=?, client_id=?, department_id=? WHERE id_project=?;
sql.delete_by_id_project = DELETE FROM projects WHERE id_project=?;
sql.find_project_by_id = SELECT * FROM projects WHERE id_project=?;

sql.create_task = INSERT INTO tasks (task_name, task_description, priority, status, project_id) VALUES (?, ?, ?, ?, ?);
sql.update_by_id_task = UPDATE tasks SET task_name=?, task_description=?, priority=?, status=?, project_id=? WHERE id_task=?;
sql.delete_by_id_task = DELETE FROM tasks WHERE id_task=?;
sql.find_task_by_id = SELECT * FROM tasks WHERE id_task=?;




