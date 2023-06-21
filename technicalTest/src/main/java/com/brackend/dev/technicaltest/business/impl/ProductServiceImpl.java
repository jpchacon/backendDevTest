package com.brackend.dev.technicaltest.business.impl;

import com.brackend.dev.technicaltest.business.ProductService;
import com.brackend.dev.technicaltest.clients.ProductClient;
import com.brackend.dev.technicaltest.exception.BusinessException;
import com.brackend.dev.technicaltest.model.request.ProductDetailModel;
import com.brackend.dev.technicaltest.model.request.ProductListModel;
import com.brackend.dev.technicaltest.model.response.SimilarProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductClient productClient;

    public ProductServiceImpl(ProductClient productClient){
        this.productClient = productClient;
    }

    @Override
    public SimilarProduct getProducts(Long productId){

        if(productId == null  || productId <= 0){
            throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "Id cant null o less than 0");
        }

        productClient.getProduct(productId);

        List<Long> similarIdProducts = productClient.getSimilarIdProducts(productId);

        if(similarIdProducts.isEmpty()){
            throw new BusinessException(HttpStatus.NO_CONTENT.value(), "There are no similar products");
        }
        List<ProductDetailModel> productsTmp = new ArrayList<>();

        similarIdProducts.forEach(idx->{
            ProductDetailModel prodctDetail = productClient.getProduct(idx);
            productsTmp.add(prodctDetail);
        });

        SimilarProduct similarProducts = new SimilarProduct();
        similarProducts.setProducts(productsTmp);

        return similarProducts;
    }

}
