CREATE TABLE IF NOT EXISTS blocked_position (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO blocked_position (id, name)
VALUES
    (1, 'Example position 1'),
    (2, 'Example position 2'),
    (3, 'Example position 3')
ON CONFLICT (id) DO NOTHING;
