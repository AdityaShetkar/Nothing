package com.cryptocurrencyOrders.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

    UUID buyerUserId;
    UUID sellerUserId;
    BigDecimal price;
    String ordersType;
    UUID userId;
    BigDecimal buyQuantity;
    BigDecimal sellQuantity;
    BigDecimal executedQuantity;

}
