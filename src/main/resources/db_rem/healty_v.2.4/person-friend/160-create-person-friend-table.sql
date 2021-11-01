CREATE TABLE person_friend (
  person_id BIGINT NOT NULL,
  friend_id BIGINT NOT NULL,
  PRIMARY KEY (person_id, friend_id),
  FOREIGN KEY (person_id)
      REFERENCES persons (id),
  FOREIGN KEY (friend_id)
      REFERENCES persons (id)
);