package com.brackend.dev.technicaltest.clients;

import com.brackend.dev.technicaltest.config.FeignConfig;
import com.brackend.dev.technicaltest.model.request.ProductDetailModel;
import com.brackend.dev.technicaltest.model.request.ProductListModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "product", url = "${external.mock.api.base-url}", configuration = FeignConfig.class)
public interface ProductClient {

    @GetMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ProductDetailModel getProduct(@PathVariable("productId") Long productId);

    @GetMapping(value = "/{productId}/similarids")
    List<Long> getSimilarIdProducts(@PathVariable("productId") Long productId);
}
