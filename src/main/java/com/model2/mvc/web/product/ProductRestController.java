package com.model2.mvc.web.product;

import com.model2.mvc.service.Product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/*")
public class ProductRestController {


    @Autowired
    @Qualifier(productServiceImpl)
    private ProductService productService;

    public ProductRestController() {
        System.out.println("Product Default Constructor start");
    }
    @RequestMapping( value="json/getProduct/{prodNo}", method= RequestMethod.GET )
    public Product getProduct(@PathVariable int prodNo ) throws Exception{

        System.out.println("/user/json/getProdNo : GET");

        //Business Logic
        return productService.getProduct(prodNo);


    }


}
