package com.erimler.product_service.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MainController {
    @GetMapping("/ping")
    fun ping():Any{
        return "Servis is Running"
    }
}