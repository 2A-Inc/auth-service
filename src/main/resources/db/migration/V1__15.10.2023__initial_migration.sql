CREATE TABLE users
(
    id          SERIAL,
    first_name  VARCHAR(20),
    middle_name VARCHAR(20),
    last_name   VARCHAR(20),
    email       VARCHAR(20),
    password    VARCHAR(200),
    user_role   VARCHAR(40),
    avatar_url  TEXT,
    birth_day   TIMESTAMP WITHOUT TIME ZONE,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    description TEXT,
    CONSTRAINT pk_user_id PRIMARY KEY (id)
)