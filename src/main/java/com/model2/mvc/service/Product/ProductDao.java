package com.model2.mvc.service.Product;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

import java.util.List;

public interface ProductDao {


    // INSERT
    public void addProduct(Product product) throws Exception ;

    // SELECT ONE
    public Product getProduct(int prodNo) throws Exception ;

    // SELECT LIST
    public List<Product> getProductList(Search search) throws Exception ;

    // UPDATE
    public void updateProduct(Product product) throws Exception ;

    // 게시판 Page 처리를 위한 전체Row(totalCount)  return
    //select one 받아올꺼임
    public int getTotalCount(Search search) throws Exception ;

}
