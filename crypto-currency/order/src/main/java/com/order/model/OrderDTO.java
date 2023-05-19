package com.order.model;

import com.order.Enums.OrderStatus;
import com.order.Enums.OrderType;
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
public class OrderDTO {

    UUID userId;
    String orderNumber;
    UUID cryptoCurrencyId;
    BigDecimal quantity;
    BigDecimal amount;
    OrderType orderType;
    OrderStatus orderStatus;

}
