CREATE TABLE watchlist (
    movie_id VARCHAR(255) PRIMARY KEY,
    movie_name VARCHAR(255),
    movie_poster VARCHAR(255),
    movie_title VARCHAR(255),
    release_date DATE
);
ALTER TABLE watchlist
ADD COLUMN user_email VARCHAR(255);