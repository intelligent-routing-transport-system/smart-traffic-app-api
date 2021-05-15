package br.com.smarttraffic.appapi.configurations;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FeignCognitoConfigurations {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    RequestInterceptor requestInterceptor(@Value("${smart-traffic-security.app-client-id}") String appClientId,
                                          @Value("${smart-traffic-security.app-client-secret}") String appClientSecret) {
        return new FeignCognitoConfigurations.AuthRequestInterceptor(appClientId, appClientSecret);
    }

    @Bean
    public Encoder encoder() {
        return new FormEncoder();
    }

    public class AuthRequestInterceptor implements RequestInterceptor {

        private final String appClientId, appClientSecret;

        public AuthRequestInterceptor(String appClientId, String appClientSecret) {
            this.appClientId = appClientId;
            this.appClientSecret = appClientSecret;
        }

        private String toBasicAuthorization() {
            return "Basic ".concat(Base64.getEncoder().encodeToString(appClientId.concat(":").concat(appClientSecret).getBytes(StandardCharsets.UTF_8)));
        }

        @Override
        public void apply(RequestTemplate requestTemplate) {
            requestTemplate.header("Authorization", toBasicAuthorization());
        }
    }
}
