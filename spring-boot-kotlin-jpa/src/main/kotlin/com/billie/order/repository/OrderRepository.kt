package com.billie.order.repository

import com.billie.order.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>, OrderRepositoryCustom {
}