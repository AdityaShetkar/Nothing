CREATE table IF NOT EXISTS crypto_currency(
    id uuid NOT NULL,
    crypto_id uuid NOT NULL,
    currency_id uuid NOT NULL,
    crypto_currency_id uuid NOT NULL,
    pair varchar(255),
    last_trading_price decimal NOT NULL,
    last_trading_quantity decimal NOT NULL,
    previous_close decimal NOT NULL,
    PRIMARY KEY(id)

)