package br.com.smarttraffic.appapi.configurations;

import br.com.smarttraffic.appapi.clients.CognitoOauthApiClient;
import br.com.smarttraffic.appapi.dtos.CognitoAuthResponseDto;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class TokenCache {

    private final static String GRANT_TYPE = "client_credentials";
    private final static String TOKEN_KEY = "TOKEN";
    private final LoadingCache<String, CognitoAuthResponseDto> loadingCache;
    private final CognitoOauthApiClient cognitoOauthApiClient;

    public TokenCache(CognitoOauthApiClient cognitoOauthApiClient) {
        this.cognitoOauthApiClient = cognitoOauthApiClient;
        loadingCache = buildTokenCaffeine();
    }

    public String getToken() {
        CognitoAuthResponseDto cognitoAuthResponseDto = loadingCache.get(TOKEN_KEY);
        return cognitoAuthResponseDto.getTokenType().concat(" ").concat(cognitoAuthResponseDto.getAccessToken());
    }

    private LoadingCache<String, CognitoAuthResponseDto> buildTokenCaffeine() {
        return Caffeine.newBuilder().expireAfter(new Expiry<String, CognitoAuthResponseDto>() {
            @Override
            public long expireAfterCreate(String key, CognitoAuthResponseDto value, long l) {
                return value.getExpiresIn();
            }

            @Override
            public long expireAfterUpdate(String key, CognitoAuthResponseDto value, long l, long l1) {
                return value.getExpiresIn();
            }

            @Override
            public long expireAfterRead(String key, CognitoAuthResponseDto value, long l, long l1) {
                return value.getExpiresIn();
            }
        }).build((key) -> callToCognitoOauth(key));
    }

    private CognitoAuthResponseDto callToCognitoOauth(String key) {
        CognitoAuthResponseDto body = this.cognitoOauthApiClient.getAccessToken(GRANT_TYPE).getBody();
        return body;
    }
}
