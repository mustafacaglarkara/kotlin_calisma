package com.erimler.product_service.dto

import jakarta.validation.constraints.NotBlank


data class ProductDTO(
    val id: Int?,
    @get:NotBlank(message = "productDTO.productCode cannot be blank")
    val productCode: String,
    @get:NotBlank(message = "productDTO.productName cannot be blank")
    val productName: String,
    @get:NotBlank(message = "productDTO.productDescription cannot be blank")
    val productCategory: String,
)