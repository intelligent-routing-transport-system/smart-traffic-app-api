package br.com.smarttraffic.appapi.configurations;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

public class FeignSmartTrafficConfigurations {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    RequestInterceptor requestInterceptor(@Value("${smart-traffic-security.api-key}") String apiKey,
                                          TokenCache tokenCache){
        return new AuthRequestInterceptor(apiKey, tokenCache.getToken());
    }

    public class AuthRequestInterceptor implements RequestInterceptor{

        private final String apiKey, token;

        public AuthRequestInterceptor(String apiKey, String token) {
            this.apiKey = apiKey;
            this.token = token;
        }

        @Override
        public void apply(RequestTemplate requestTemplate) {
            requestTemplate.header("Authorization",token);
            requestTemplate.header("x-api-key",apiKey);
        }
    }
}
