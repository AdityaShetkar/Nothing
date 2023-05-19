package com.order.model;

import com.order.Enums.OrderStatus;
import com.order.Enums.OrderType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Table(name = "orders")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    UUID id;
    UUID userId;
    String orderNumber;
    UUID cryptoCurrencyId;
    BigDecimal quantity;
    BigDecimal amount;
    OrderType orderType;
    OrderStatus orderStatus;
    LocalDate createdDate;
    LocalDate updatedDate;

}

