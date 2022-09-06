create table users (
    id  UUID PRIMARY KEY NOT NULL,
    name          VARCHAR(50),
    surname       VARCHAR(50),
    email         VARCHAR(50),
    phone         VARCHAR(15)
    );
create table product(
    id SERIAL PRIMARY KEY NOT NULL,
    name          VARCHAR(50),
    price         float ,
    expiration_date timestamp

    );
create table product_comment (
    id SERIAL PRIMARY KEY NOT NULL,
    comment   VARCHAR (500),
    comment_date  timestamp ,
    product_id   int ,
    user_id      UUID,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES users(id)

    );