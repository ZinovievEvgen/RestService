CREATE TABLE person_access_list (
  person_id BIGINT NOT NULL,
  task_id BIGINT NOT NULL,
  PRIMARY KEY (person_id, task_id),
  FOREIGN KEY (person_id)
      REFERENCES persons (id),
  FOREIGN KEY (task_id)
      REFERENCES tasks (id)
);