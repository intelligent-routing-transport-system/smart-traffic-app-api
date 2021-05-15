package br.com.smarttraffic.appapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CognitoAuthRequestDto {
    @JsonProperty("grant_type")
    private String grantType;
}
