package cryptocurrencymappingservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CryptoRequestDto {
    private UUID id;
    private String name;
    private String symbol;
    private BigDecimal quotation;
}
