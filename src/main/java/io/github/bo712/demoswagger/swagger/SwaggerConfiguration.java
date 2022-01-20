package io.github.bo712.demoswagger.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author K.Babakov
 * @since 20 янв. 2022 г.
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Bookshelf")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("linuksoid@gmail.com")
                                                .url("https://bo712.github.io")
                                                .name("Konstantin Babakov")
                                )
                );
    }
}
