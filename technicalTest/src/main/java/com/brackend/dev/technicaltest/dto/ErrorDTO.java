package com.brackend.dev.technicaltest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

    private String message;
}
