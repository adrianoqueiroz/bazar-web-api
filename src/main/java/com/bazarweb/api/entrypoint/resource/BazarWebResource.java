package com.bazarweb.api.entrypoint.resource;

import com.bazarweb.api.entrypoint.model.ProductsResponse;
import com.bazarweb.api.entrypoint.resource.swagger.BazarWebSwagger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BazarWebResource implements BazarWebSwagger {
    @Override
    public ResponseEntity<ProductsResponse> validateAccount(String authorization) {
        return null;
    }
}
