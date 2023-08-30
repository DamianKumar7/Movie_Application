CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email_id VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Optional: Create a unique constraint on the email_id column
ALTER TABLE users ADD CONSTRAINT unique_email_id UNIQUE (email_id);