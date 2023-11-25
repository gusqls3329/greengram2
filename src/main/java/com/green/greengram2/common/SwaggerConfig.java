package com.green.greengram2.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정?
public class SwaggerConfig {
    // Swagger 사이트 제목 수정
    @Bean
    public OpenAPI openAPI(){

            return new OpenAPI()
                    .components(new Components())
                    .info(apiInfo()); //apiInfo() 아래 메소드 호출 , info메소드 파라미터 타입은 info반환타입이 아래의 info라서
    }
    private Info apiInfo(){
        return new Info().title("Greengram Ver.2")
                .description("인스타 클론 코딩")
                .version("2.0.0");
    }
}
