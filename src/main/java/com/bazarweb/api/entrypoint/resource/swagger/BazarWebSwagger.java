package com.bazarweb.api.entrypoint.resource.swagger;

import com.bazarweb.api.entrypoint.model.ProductsResponse;
import com.bazarweb.api.entrypoint.model.ResponseError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

//@Tag(tags = "BazarWeb")
@RequestMapping("/v1")
public interface BazarWebSwagger {
    @Operation(
        summary = "Listar produtos",
        description = "Lista produtos cadastrados na base de dados",
        tags = "BazarWeb"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Requisição bem sucedida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "400", description = "Os dados enviados estão incorretos", content = @Content(schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "412", description = "Precondition Failed", content = @Content(schema = @Schema(implementation = ResponseError.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ResponseError.class))),
    })
    @GetMapping("/products")
    ResponseEntity<ProductsResponse> validateAccount(
        @RequestHeader(name = "Authorization", required = false) String authorization
    );
}