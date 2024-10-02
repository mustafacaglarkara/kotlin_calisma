package com.erimler.product_service.repository

import com.erimler.product_service.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository:CrudRepository<Product,Int> {
}