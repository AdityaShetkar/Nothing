CREATE TABLE orders
(
    id uuid NOT NULL ,
    user_id uuid,
    order_number varchar(255),
    crypto_currency_id uuid,
    quantity decimal,
    amount decimal,
    primary key(id)
    );