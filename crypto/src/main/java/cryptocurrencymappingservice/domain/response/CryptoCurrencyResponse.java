package cryptocurrencymappingservice.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CryptoCurrencyResponse {

    private UUID cryptoId;
    private UUID currencyId;

    private UUID cryptoCurrencyId;
    private String pair;
    private BigDecimal lastTradingPrice;
    private BigDecimal lastTradingQuantity;
    private BigDecimal previousClose;
}
