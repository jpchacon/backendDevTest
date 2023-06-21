package com.brackend.dev.technicaltest.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StashErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            return new BusinessException(HttpStatus.NOT_FOUND.value(),"The product does not exist");
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new BusinessException(
                    response.status(),
                    response.reason()
            );
        }
        return new Exception(response.reason());
    }
}
