package com.erimler.product_service.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MainController {

    @Value("\${messages}")
    lateinit var serviceName:String

    @GetMapping("/ping")
    fun ping():Any{
        return "${serviceName} Servis is Running"
    }
}