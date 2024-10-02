package com.erimler.product_service.repository

import com.erimler.product_service.entity.Product
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository:CrudRepository<Product,Int> {
    fun findByProductCode(productCode:String): Optional<Product>
//    @Modifying
//    @Query("UPDATE Product p SET p.productCode = :productCode, p.productName = :productName, p.productCategory = :productCategory WHERE p.id = :id")
//    fun updateById(
//        @Param("id") id: Int,
//        @Param("productCode") productCode: String,
//        @Param("productName") productName: String,
//        @Param("productCategory") productCategory: String
//    )
}