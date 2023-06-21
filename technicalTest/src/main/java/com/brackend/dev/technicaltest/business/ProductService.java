package com.brackend.dev.technicaltest.business;

import com.brackend.dev.technicaltest.model.response.SimilarProduct;

public interface ProductService {

    public SimilarProduct getProducts(Long productId);
}
