package cryptocurrencymappingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import cryptocurrencymappingservice.domain.request.CreateCryptoCurrencyDto;
import cryptocurrencymappingservice.domain.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface CryptoCurrencyService {

    public BaseResponse saveCryptoCurrency(CreateCryptoCurrencyDto createCryptoCurrencyDto) throws JsonProcessingException;
    public ResponseEntity<BaseResponse> findCryptoCurrency(UUID userId);
    public BaseResponse findCryptoCurrencyByCryptoCurrencyId(UUID cryptoCurrencyId);

    public BaseResponse updateLastTradingPriceandQuantityByCryptoCurrencyId(UUID cryptoCurrencyId, BigDecimal price , BigDecimal quantity);



}
