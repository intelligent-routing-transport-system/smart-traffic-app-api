package br.com.smarttraffic.appapi.configurations;

import br.com.smarttraffic.appapi.clients.CognitoOauthApiClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InitConfiguration {

    private final CognitoOauthApiClient cognitoOauthApiClient;

    @Bean
    @PostConstruct
    public TokenCache PosConstruct() {
        return new TokenCache(cognitoOauthApiClient);
    }
}
