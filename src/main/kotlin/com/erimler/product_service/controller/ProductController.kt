package com.erimler.product_service.controller

import com.erimler.product_service.dto.ProductDTO
import com.erimler.product_service.entity.Product
import com.erimler.product_service.service.ProductService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/product")
class ProductController(val productService: ProductService) {

    companion object :KLogging()
    //@Autowire
    //lateinit var productService: ProductService

    @GetMapping("")
    fun product_index():MutableIterable<ProductDTO>{
        var products = productService.getAllProducts()
        logger.info {
            "Product Index Logging..."
        }
        return products
    }

    @GetMapping("/{stock_code}")
    fun getProductByStockCode(@PathVariable("stock_code") stock_code:String):String{
        logger.info {
            "Product GetByProductByStockCode Logging..."
        }
        return productService.getProductByStockCode(stock_code)
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody productDTO: ProductDTO): ProductDTO {
        return productService.addProduct(productDTO)
    }

}