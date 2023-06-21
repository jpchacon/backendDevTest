package com.brackend.dev.technicaltest.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailModel implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private Boolean availability;

    private static final long serialVersionUID = -5037663903076159414L;
}
