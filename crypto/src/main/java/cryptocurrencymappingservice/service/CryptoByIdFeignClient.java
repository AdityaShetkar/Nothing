package cryptocurrencymappingservice.service;

import cryptocurrencymappingservice.domain.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
@FeignClient(name = "crypto-client", url = "${crypto.service.url}")
public interface CryptoByIdFeignClient {
    @GetMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> findByCryptoCurrencyId(@PathVariable (name = "cryptoCurrencyId") UUID id);
}
