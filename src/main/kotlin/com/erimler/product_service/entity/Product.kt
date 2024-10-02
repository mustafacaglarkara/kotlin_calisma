package com.erimler.product_service.entity

import jakarta.persistence.*

@Entity
@Table(name="Product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int?=null,
    val productCode:String="",
    val productName:String="",
    val productCategory:String="",
)