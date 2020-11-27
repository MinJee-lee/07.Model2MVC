package com.model2.mvc.service.Product.impl;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.Product.ProductDao;
import com.model2.mvc.service.domain.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {
    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    ///Constructor
    public ProductDaoImpl() {
        System.out.println(this.getClass());
    }

    @Override
    public void addProduct(Product product) throws Exception {
       sqlSession.insert("ProductMapper.addProduct",product); //productMapper안에 addProduct로 product값을 받는다

    }

    @Override//값을 product mapping으로 보내줌
    public Product getProduct(int productNo) throws Exception {
        return sqlSession.selectOne("ProductMapper.getProduct",productNo);
    }

    @Override
    public List<Product> getProductList(Search search) throws Exception {
        return sqlSession.selectList("ProductMapper.getProductList",search);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        sqlSession.update("ProductMapper.updateProduct",product);

    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        return sqlSession.selectOne("ProductMapper.getTotalCount",search);
    }
}
