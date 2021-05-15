package br.com.smarttraffic.appapi.clients;

import br.com.smarttraffic.appapi.configurations.FeignCognitoConfigurations;
import br.com.smarttraffic.appapi.dtos.CognitoAuthResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cognito-oauth", url = "${endpoints.cognito-oauth}", configuration = FeignCognitoConfigurations.class)
public interface CognitoOauthApiClient {
    @PostMapping(value = "oauth2/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<CognitoAuthResponseDto> getAccessToken(@RequestParam("grant_type") String grant_type);
}
