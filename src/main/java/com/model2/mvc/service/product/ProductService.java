package com.model2.mvc.service.product;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

import java.util.Map;

public interface ProductService {

    // 상품등록
    public void addProduct(Product product) throws Exception ;

    // 상품정보 확인
    public Product getProduct(int productNo) throws Exception ;

    // 상품정보 리스트
    public Map<String,Object> getProductList(Search search) throws Exception ;

    // 상품 정보 수정
    public void updateProduct(Product product) throws Exception ;


}
