package com.billie.order.entity

import jakarta.persistence.*

@Entity
@Table(name = "orders_item")
class OrderItem (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val productCode: String,

    @Column
    val productName: String,

    @Column
    val quantity: Long,

    @Column
    val cancelQuantity: Long,

    @Column
    val shipmentQuantity: Long,
)