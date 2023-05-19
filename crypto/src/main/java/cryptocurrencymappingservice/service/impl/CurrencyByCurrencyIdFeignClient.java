package cryptocurrencymappingservice.service.impl;

import cryptocurrencymappingservice.domain.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@FeignClient(name = "currency-service-feign-client", url = "${currency.service.url}")
public interface CurrencyByCurrencyIdFeignClient {

    @GetMapping("/{currencyId}")
    public ResponseEntity<BaseResponse> findByCurrencyId(@PathVariable(name = "currencyId") UUID id);
}
