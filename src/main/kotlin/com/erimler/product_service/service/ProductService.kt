package com.erimler.product_service.service

import com.erimler.product_service.dto.ProductDTO
import com.erimler.product_service.entity.Product
import com.erimler.product_service.repository.ProductRepository
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
){
    @Value("\${messages}")
    lateinit var serviceName:String
    companion object :KLogging()

    fun product_index():Any {
        return "Product Services"
    }
    fun getProductByStockCode(stock_code:String):String{
        return "${serviceName }Product By Stock Code: $stock_code"
    }

    fun getAllProducts(): MutableIterable<ProductDTO> {
        var tmpProductDto : MutableList<ProductDTO> = mutableListOf()
        productRepository.findAll().forEach {
            tmpProductDto.add(ProductDTO(it.id,it.productCode,it.productName,it.productCategory))
        }
        return tmpProductDto
    }
    fun addProduct(productDTO: ProductDTO): ProductDTO {
        // Let Kullanımı Önemli Eğer Dolu ise let kullanılır.
        var tmpProduct = productDTO.let {
            Product(
                null,it.productCode,it.productName,it.productCode
            )
        }
//        var tmpProduct = Product(
//            productDTO.id,
//            productDTO.productCode,
//            productDTO.productName,
//            productDTO.productCategory,
//        )
        productRepository.save(tmpProduct)
        logger().info { "${productDTO.productName} adlı ürün kayıt edildi." }

        return tmpProduct.let {
            ProductDTO(
                it.id,it.productCategory,it.productName,it.productCategory
            )
        }
    }
}