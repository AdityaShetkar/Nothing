package cryptocurrencymappingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crypto_currency")

@Builder
@Data
public class CryptoCurrency {
    @Id
    private UUID Id;
    private UUID cryptoId;
    private UUID currencyId;
    private UUID cryptoCurrencyId;
    private String pair;
    private BigDecimal lastTradingPrice;
    private BigDecimal lastTradingQuantity;
    private BigDecimal previousClose;


}

