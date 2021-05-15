package br.com.smarttraffic.appapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponseRouteByIdDto {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("name")
    private String name;
    @JsonProperty("incidents")
    private List<Incident> incidents = null;
    @JsonProperty("route")
    private List<Route> route = null;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Incident{
        @JsonProperty("_id")
        private String id;
        @JsonProperty("Coords")
        private Coords coords;
        @JsonProperty("BlockPoint")
        private Boolean blockPoint;
        @JsonProperty("ActionRadius")
        private Integer actionRadius;
        @JsonProperty("loc")
        private List<Double> loc = null;
        @JsonProperty("LastModifiedDate")
        private Long lastModifiedDate;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Route{
        @JsonProperty("latitude")
        private Double latitude;
        @JsonProperty("longitude")
        private Double longitude;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coords{
        @JsonProperty("Latitude")
        private Double latitude;
        @JsonProperty("Longitude")
        private Double longitude;
    }
}
