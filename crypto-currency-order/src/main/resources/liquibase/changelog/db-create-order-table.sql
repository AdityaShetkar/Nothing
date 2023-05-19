
create TABLE Orders
(
    id UUID NOT NULL Primary Key ,
    Orders_number varchar(255),
    buyer_user_id UUID,
    seller_user_id UUID,
    price decimal,
    Orders_type varchar(10),
    user_id UUID,
    buy_quantity decimal,
    sell_quantity decimal,
    executed_quantity decimal,
    Orders_status varchar(10)
    );