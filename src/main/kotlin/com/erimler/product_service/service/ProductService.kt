package com.erimler.product_service.service

import com.erimler.product_service.dto.ProductDTO
import com.erimler.product_service.entity.Product
import com.erimler.product_service.exception.ProductNotFoundException
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

    fun getProductById(productId: Int):ProductDTO {
        var tmpProduct = productRepository.findById(productId)
        return if(tmpProduct.isPresent) {
            tmpProduct.get().let {
                ProductDTO(
                    id=it.id,
                    productCode =it.productCode,
                    productName =it.productName,
                    productCategory =it.productCategory
                )
            }

        }else{
            throw ProductNotFoundException("Girilen $productId Id'ye göre Ürün Bulunamadı")
        }
    }
    fun findByProductCode(product_code: String): ProductDTO {
        var tmpProduct = productRepository.findByProductCode(product_code)
        return if(tmpProduct.isPresent){
            tmpProduct.get().let{
                ProductDTO(
                    id=it.id,
                    productCode = it.productCode,
                    productName= it.productName,
                    productCategory= it.productCategory
                )
            }
        }else{
            throw ProductNotFoundException("Girilen $product_code ürün koduna  göre Ürün Bulunamadı")
        }
    }
    fun getAllProducts(): List<ProductDTO> {
//        var tmpProductDto : MutableList<ProductDTO> = mutableListOf()
//        productRepository.findAll().forEach {
//            tmpProductDto.add(ProductDTO(it.id,it.productCode,it.productName,it.productCategory))
//        }
//        return tmpProductDto
        // map listelerde işlem için kullanılır geriye liste döner.
        var tmpList = productRepository.findAll().map {
            ProductDTO(it.id,it.productCode,it.productName,it.productCategory)
        }
        return tmpList
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
    fun updateProduct(productId:Int, productDTO:ProductDTO): ProductDTO {
        var course = productRepository.findById(productId)
        return if(course.isPresent){
            course.get().let {
                it.productName = productDTO.productName
                it.productCode = productDTO.productCode
                it.productCategory = productDTO.productCategory
                productRepository.save(it)
                ProductDTO(it.id,it.productCode,it.productName,it.productCategory)
            }
        }else{
            throw ProductNotFoundException("Girilen $productId Id'ye göre Ürün Bulunamadı")
        }
    }

}