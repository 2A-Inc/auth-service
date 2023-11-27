CREATE TABLE IF NOT EXISTS refresh_token
(
    id    VARCHAR(100) UNIQUE,
    token TEXT NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY (id)
);