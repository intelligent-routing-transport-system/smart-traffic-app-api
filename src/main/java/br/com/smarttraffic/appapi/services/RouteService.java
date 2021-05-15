package br.com.smarttraffic.appapi.services;

import br.com.smarttraffic.appapi.clients.DirectionsApiClient;
import br.com.smarttraffic.appapi.clients.NotificatorApiClient;
import br.com.smarttraffic.appapi.dtos.DirectionsResponseRouteByIdDto;
import br.com.smarttraffic.appapi.dtos.DirectionsResponseRoutesDto;
import br.com.smarttraffic.appapi.dtos.NotificatorVersionDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RouteService {

    private final DirectionsApiClient directionsApiClient;
    private final NotificatorApiClient notificatorApiClient;

    public List<DirectionsResponseRoutesDto> getRoutes() {
        return directionsApiClient.getRoutes();
    }

    public DirectionsResponseRouteByIdDto getRouteById(String id) {
        return directionsApiClient.getRouteById(id);
    }

    public Object test() {
        ResponseEntity<NotificatorVersionDto> version = notificatorApiClient.version();
        return version.getBody();
    }
}
