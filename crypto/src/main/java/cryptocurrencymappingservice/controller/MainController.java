package cryptocurrencymappingservice.controller;


import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import cryptocurrencymappingservice.domain.request.CreateCryptoCurrencyDto;
import cryptocurrencymappingservice.domain.response.BaseResponse;
import cryptocurrencymappingservice.service.CryptoCurrencyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/cryptomappingcurrency")
public class MainController {
    private final CryptoCurrencyService cryptoCurrencyService;

    @PostMapping()
    @CircuitBreaker(name = "currencyServiceBreaker", fallbackMethod = "currencyFailedMethod")
    public ResponseEntity<BaseResponse> addMapping(@RequestBody CreateCryptoCurrencyDto createCryptoCurrencyDto) throws JsonProcessingException {
        return ResponseEntity.ok()
                .body(cryptoCurrencyService.saveCryptoCurrency(createCryptoCurrencyDto));
    }

    public ResponseEntity<BaseResponse> currencyFailedMethod( CreateCryptoCurrencyDto createCryptoCurrencyDto, Exception exception) throws JsonProcessingException {
        log.info("currency service failed");

        return ResponseEntity.ok().body(new BaseResponse(HttpStatus.NO_CONTENT.value(), "curency service is out of service",null,null));
    }


    @GetMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> findCryptoCurrencyByCryptoCurrencyId(@PathVariable UUID cryptoCurrencyId) {
        return ResponseEntity.ok()
                .body(cryptoCurrencyService.findCryptoCurrencyByCryptoCurrencyId(cryptoCurrencyId));
    }

    @PutMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> updateTradingPriceAndQuantity(@PathVariable UUID cryptoCurrencyId, @RequestParam BigDecimal price, @RequestParam BigDecimal quantity) {
        return ResponseEntity.ok().body(cryptoCurrencyService.updateLastTradingPriceandQuantityByCryptoCurrencyId(cryptoCurrencyId, price, quantity));
    }
}
