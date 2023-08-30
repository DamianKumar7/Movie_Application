CREATE TABLE liked_movies (
    movie_id VARCHAR(255) PRIMARY KEY,
    movie_name VARCHAR(255),
    movie_poster VARCHAR(255),
    movie_title VARCHAR(255),
    release_date DATE
);
ALTER TABLE liked_movies
ADD COLUMN user_email VARCHAR(255);

ALTER TABLE liked_movies
DROP COLUMN movie_title;