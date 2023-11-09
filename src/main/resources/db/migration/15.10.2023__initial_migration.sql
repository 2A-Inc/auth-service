CREATE TABLE users(
    id SERIAL,
    first_name VARCHAR(20),
    middle_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR (20),
    avatar_url TEXT,
    birth_day TIMESTAMP WITHOUT TIME ZONE,
    description TEXT,
    CONSTRAINT pk_user_id PRIMARY KEY (id)
)