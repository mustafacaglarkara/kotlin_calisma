package com.erimler.product_service.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController {

    @GetMapping("")
    fun product_index():Any{
        return "Product Index"
    }

    @GetMapping("/{stock_code}")
    fun getProductByStockCode(@PathVariable("stock_code") stock_code:String):String{
        return "Product By Stock Code: $stock_code"
    }

}