package cryptocurrencymappingservice.domain.response;

import cryptocurrencymappingservice.domain.request.CurrencyRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CurrencyResponse <T>{
    private int statusCode;
    private String message;
    private T error;
    private CurrencyRequestDto currencyRequestDto;
}
