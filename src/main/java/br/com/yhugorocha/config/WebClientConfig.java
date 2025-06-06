package br.com.yhugorocha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "solicitationWebClient")
    public WebClient solicitationWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/api/v1/solicitations")
                .build();
    }
}
