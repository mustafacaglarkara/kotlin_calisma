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
    fun getAllProduct():List<ProductDTO>{
        var products = productService.getAllProducts()
        logger.info {
            "Product Index Logging..."
        }
        return products
    }
    @GetMapping("/product")
    fun getProduct(@RequestParam(required = false) productCode: String?, @RequestParam(required = false) productId: Int?): ProductDTO? {
        logger.info { "Product GetByProduct Logging..." }

        return when {
            productCode != null -> productService.findByProductCode(productCode)
            productId != null -> productService.getProductById(productId)
            else -> throw IllegalArgumentException("Either productCode or productId must be provided.")
        }
    }
//    @GetMapping("/{productCode}")
//    fun getProductByStockCode(@PathVariable("productCode") productCode:String):ProductDTO{
//        logger.info {
//            "Product GetByProductByStockCode Logging..."
//        }
//        //return productService.getProductByStockCode(stock_code)
//        return productService.findByProductCode(productCode)
//    }

//    @GetMapping("/{productId}")
//    fun getProductByStockCode(@PathVariable("productId") productId:Int):ProductDTO{
//        logger.info {
//            "Product GetByProductByStockCode Logging..."
//        }
//        //return productService.getProductByStockCode(stock_code)
//        return productService.getProductById(productId)
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody productDTO: ProductDTO): ProductDTO {
        return productService.addProduct(productDTO)
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateProduct(@RequestBody productDTO: ProductDTO, @PathVariable("productId") productId:Int):ProductDTO{
        return productService.updateProduct(productId, productDTO)
    }

}