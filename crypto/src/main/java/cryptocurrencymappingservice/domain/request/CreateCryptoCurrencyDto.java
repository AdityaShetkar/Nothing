package cryptocurrencymappingservice.domain.request;

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
public class CreateCryptoCurrencyDto {

    private UUID cryptoId;
    private UUID currencyId;
    private BigDecimal lastTradingPrice;
    private BigDecimal lastTradingQuantity;
    private BigDecimal previousClose;
    private String pair;
}
