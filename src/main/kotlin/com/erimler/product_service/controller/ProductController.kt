package com.erimler.product_service.controller

import com.erimler.product_service.service.ProductService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController(val productService: ProductService) {

    companion object :KLogging()
    //@Autowire
    //lateinit var productService: ProductService

    @GetMapping("")
    fun product_index():Any{
        logger.info {
            "Product Index Logging..."
        }
        return productService.product_index()
    }

    @GetMapping("/{stock_code}")
    fun getProductByStockCode(@PathVariable("stock_code") stock_code:String):String{
        logger.info {
            "Product GetByProductByStockCode Logging..."
        }
        return productService.getProductByStockCode(stock_code)
    }

}