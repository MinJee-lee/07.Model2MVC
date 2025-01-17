package com.model2.mvc.service.Product.impl;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.Product.ProductDao;
import com.model2.mvc.service.Product.ProductService;
import com.model2.mvc.service.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productDaoImpl")
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    ///Constructor
    public ProductServiceImpl() {
        System.out.println(this.getClass());
    }

    ///Method
    @Override
    public void addProduct(Product product) throws Exception {
        productDao.addProduct(product);
    }

    public Product getProduct(int prodNo) throws Exception {
        return productDao.getProduct(prodNo);
    }

    public Map<String, Object> getProductList(Search search) throws Exception {
        List<Product> list = productDao.getProductList(search);
        int totalCount = productDao.getTotalCount(search);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("totalCount", new Integer(totalCount));

        return map;
    }

    public void updateProduct(Product product) throws Exception {
        productDao.updateProduct(product);
    }
}
