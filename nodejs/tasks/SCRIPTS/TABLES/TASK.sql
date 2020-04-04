CREATE TABLE TASKS (
TASK_ID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
TASK_DESC VARCHAR(30) NOT NULL,
TASK_REF VARCHAR(30) NOT NULL,
TASK_STATUS VARCHAR(50),
UPDATED_ON TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)



