CREATE TABLE IF NOT EXISTS tasks
(
    id          CHAR(36)                    NOT NULL,
    header      VARCHAR(100)                NOT NULL,
    description VARCHAR(400)                NOT NULL,
    status      VARCHAR(20)                 NOT NULL,
    priority    VARCHAR(20)                 NOT NULL,
    reporter_id CHAR(36)                    NOT NULL,
    assignee_id CHAR(36)                    NOT NULL,
    date_time   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT tasks_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id          CHAR(36)               NOT NULL,
    first_name  VARCHAR(50)            NOT NULL,
    middle_name VARCHAR(50) DEFAULT '' NOT NULL,
    second_name VARCHAR(50)            NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE tasks
    ADD CONSTRAINT tasks_assignee_id_fkey FOREIGN KEY (assignee_id) REFERENCES users (id) ON DELETE NO ACTION;

ALTER TABLE tasks
    ADD CONSTRAINT tasks_reporter_id_fkey FOREIGN KEY (reporter_id) REFERENCES users (id) ON DELETE NO ACTION;