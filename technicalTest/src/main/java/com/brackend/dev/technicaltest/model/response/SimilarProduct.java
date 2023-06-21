package com.brackend.dev.technicaltest.model.response;

import com.brackend.dev.technicaltest.model.request.ProductDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarProduct implements Serializable {

    private List<ProductDetailModel> products;
    private static final long serialVersionUID = 9091000103711611326L;

}