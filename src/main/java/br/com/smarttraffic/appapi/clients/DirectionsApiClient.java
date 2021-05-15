package br.com.smarttraffic.appapi.clients;

import br.com.smarttraffic.appapi.configurations.FeignSmartTrafficConfigurations;
import br.com.smarttraffic.appapi.dtos.DirectionsResponseRouteByIdDto;
import br.com.smarttraffic.appapi.dtos.DirectionsResponseRoutesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@FeignClient(value = "directions", url = "${endpoints.smart-traffic-directions}", configuration = FeignSmartTrafficConfigurations.class)
public interface DirectionsApiClient {
    @GetMapping("route/getRoutes")
    public List<DirectionsResponseRoutesDto> getRoutes();

    @GetMapping("route/{id}")
    public DirectionsResponseRouteByIdDto getRouteById(@PathVariable("id") String id);
}
