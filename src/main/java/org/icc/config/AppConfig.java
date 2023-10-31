package org.icc.config;

import org.icc.model.ConversionHistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ConversionHistory conversionHistory() {
        return new ConversionHistory();
    }
}
