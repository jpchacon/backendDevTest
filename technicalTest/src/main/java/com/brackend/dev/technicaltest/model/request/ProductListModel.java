package com.brackend.dev.technicaltest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListModel implements Serializable {

    private List<Long> ids;
    private static final long serialVersionUID = -2857677182291304127L;
}