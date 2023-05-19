package com.cryptocurrencyOrders.model;

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
@Table(name = "Order")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    UUID id;
    String ordersNumber;
    UUID buyerUserId;
    UUID sellerUserId;
    BigDecimal price;
    String ordersType;
    UUID userId;
    BigDecimal buyQuantity;
    BigDecimal sellQuantity;
    BigDecimal executedQuantity;
    String ordersStatus;
    LocalDate createdDate;
    LocalDate updatedDate;

}
