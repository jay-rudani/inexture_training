package org.icc.config;

import org.icc.model.ConversionHistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ConversionHistory conversionHistory() {
        return new ConversionHistory();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
