package br.com.smarttraffic.appapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponseRoutesDto {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("waypoints")
    private List<Waypoint> waypoints = null;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Waypoint{
        @JsonProperty("_id")
        private Long id;
        @JsonProperty("id_waypoint")
        private Long idWaypoint;
        @JsonProperty("name_waypoint")
        private String nameWaypoint;
    }
}
