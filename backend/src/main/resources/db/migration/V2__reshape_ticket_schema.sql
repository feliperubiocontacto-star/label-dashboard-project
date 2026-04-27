DROP TABLE IF EXISTS status_history CASCADE;
DROP TABLE IF EXISTS attachments CASCADE;
DROP TABLE IF EXISTS tickets CASCADE;

CREATE TABLE tickets (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP,
    sender_email VARCHAR(255),
    client VARCHAR(255),
    type VARCHAR(50),
    description TEXT,
    due_date DATE,
    status VARCHAR(50) NOT NULL,
    priority VARCHAR(50),
    thread_id VARCHAR(255),
    approval_token VARCHAR(255)
);
