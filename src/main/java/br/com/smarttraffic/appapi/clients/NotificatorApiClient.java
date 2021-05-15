package br.com.smarttraffic.appapi.clients;

import br.com.smarttraffic.appapi.configurations.FeignSmartTrafficConfigurations;
import br.com.smarttraffic.appapi.dtos.NotificatorVersionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "notificator", url = "${endpoints.smart-traffic-notificator}", configuration = FeignSmartTrafficConfigurations.class)
public interface NotificatorApiClient {
    @GetMapping("version")
    public ResponseEntity<NotificatorVersionDto> version();
}
