package com.billie.order.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "orders")
class Order (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val orderNumber: String,

    @Column
    val customer: String,

    @Column
    val OrderedAt: Instant
)