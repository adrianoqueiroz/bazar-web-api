package com.bazarweb.api.core.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDocConfig {

    private final SwaggerProperties swaggerProperties;

    @Bean
    public OpenAPI springShopOpenAPI() {
        final var contact = new Contact();
        contact.setName(swaggerProperties.getContactName());
        contact.setUrl(swaggerProperties.getContactUrl());
        contact.setEmail(swaggerProperties.getContactEmail());

        final var license = new License()
            .name(swaggerProperties.getLicense())
            .url("http://springdoc.org");

        final var info = new Info()
            .title(swaggerProperties.getTitle())
            .description(swaggerProperties.getDescription())
            .version(swaggerProperties.getVersion())
            .license(license)
            .contact(contact);

        final var externalDoc = new ExternalDocumentation()
            .description(swaggerProperties.getExternalDocDescription())
            .url(swaggerProperties.getTermsOfServiceUrl());

        return new OpenAPI()
            .info(info)
            .externalDocs(externalDoc);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("springshop-public")
            .pathsToMatch("/v1/**")
            .packagesToScan("com.bazarweb.api.entrypoint.resource")
            .build();
    }
}
