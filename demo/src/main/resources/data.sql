-- Insert sample Authors
INSERT INTO author (name, nationality) VALUES ('George Orwell', 'British');
INSERT INTO author (name, nationality) VALUES ('J.K. Rowling', 'British');
INSERT INTO author (name, nationality) VALUES ('Agatha Christie', 'British');
INSERT INTO author (name, nationality) VALUES ('Stephen King', 'American');
INSERT INTO author (name, nationality) VALUES ('Mark Twain', 'American');

-- Insert sample Books (the author_id matches the numbers above)
INSERT INTO book (title, genre, author_id) VALUES ('1984', 'Dystopian', 1);
INSERT INTO book (title, genre, author_id) VALUES ('Animal Farm', 'Political Satire', 1);
INSERT INTO book (title, genre, author_id) VALUES ('Animal Farm', 'Political Satire', 1);
INSERT INTO book (title, genre, author_id) VALUES ('Harry Potter and the Sorcerers Stone', 'Fantasy', 2);
INSERT INTO book (title, genre, author_id) VALUES ('Harry Potter and the Sorcerers Stone', 'Fantasy', 2);
INSERT INTO book (title, genre, author_id) VALUES ('Murder on the Orient Express', 'Mystery', 3);
INSERT INTO book (title, genre, author_id) VALUES ('The Shining', 'Horror', 4);
INSERT INTO book (title, genre, author_id) VALUES ('The Shining', 'Horror', 4);
INSERT INTO book (title, genre, author_id) VALUES ('It', 'Horror', 4);
INSERT INTO book (title, genre, author_id) VALUES ('It', 'Horror', 4);
INSERT INTO book (title, genre, author_id) VALUES ('The Adventures of Tom Sawyer', 'Fiction', 5);