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
}
