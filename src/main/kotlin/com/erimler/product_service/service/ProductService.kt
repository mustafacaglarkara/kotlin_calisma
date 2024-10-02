package com.erimler.product_service.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ProductService {


    @Value("\${messages}")
    lateinit var serviceName:String

    fun product_index():Any {
        return "Product Services"
    }
    fun getProductByStockCode(stock_code:String):String{
        return "${serviceName }Product By Stock Code: $stock_code"
    }
}