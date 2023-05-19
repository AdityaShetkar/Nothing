package com.cryptocurrencyOrders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersRepository extends JpaRepository<com.cryptocurrencyOrders.model.Orders, UUID> {

    //  @Query("SELECT o FROM Orders o WHERE o.id = UUID(:id)")
    //Optional<com.cryptocurrencyOrders.model.Orders> findByUUID(@Param("id") UUID id);

    @Query(value = "select max(orders_number) from orders", nativeQuery = true)
    public String getOrdersNumber();

}
