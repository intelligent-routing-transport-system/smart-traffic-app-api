package br.com.smarttraffic.appapi.controllers;

import br.com.smarttraffic.appapi.dtos.DirectionsResponseRouteByIdDto;
import br.com.smarttraffic.appapi.dtos.DirectionsResponseRoutesDto;
import br.com.smarttraffic.appapi.services.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("routes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<DirectionsResponseRoutesDto>> getRoutes() {
        List<DirectionsResponseRoutesDto> routes = routeService.getRoutes();
        return ResponseEntity.ok(routes);
    }

    @GetMapping("{id}")
    public ResponseEntity<DirectionsResponseRouteByIdDto> getRouteById(@PathVariable("id") String id) {
        DirectionsResponseRouteByIdDto routeById = routeService.getRouteById(id);
        return ResponseEntity.ok(routeById);
    }

    @GetMapping("test")
    public ResponseEntity<?> getRouteByIds() {
        Object routeById = routeService.test();
        return ResponseEntity.ok(routeById);
    }
}
