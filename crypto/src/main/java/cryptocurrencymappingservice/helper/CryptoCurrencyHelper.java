package cryptocurrencymappingservice.helper;

import cryptocurrencymappingservice.domain.request.CreateCryptoCurrencyDto;
import cryptocurrencymappingservice.domain.response.CryptoCurrencyResponse;
import cryptocurrencymappingservice.entity.CryptoCurrency;

import java.util.UUID;

public class CryptoCurrencyHelper {
    private CryptoCurrencyHelper() {
    }

    public static CryptoCurrency entitytoDto(CreateCryptoCurrencyDto createCryptoCurrencyDto) {
        return CryptoCurrency.builder().cryptoCurrencyId(UUID.randomUUID())
                .cryptoId(createCryptoCurrencyDto.getCryptoId())
                .currencyId(createCryptoCurrencyDto.getCurrencyId())
                .lastTradingPrice(createCryptoCurrencyDto.getLastTradingPrice())
                .previousClose(createCryptoCurrencyDto.getPreviousClose()).
                Id(UUID.randomUUID())
                .lastTradingQuantity(createCryptoCurrencyDto.getLastTradingQuantity()).build();
    }

    public static CryptoCurrencyResponse buildResponseFromEntity(CryptoCurrency cryptoCurrency) {
        return CryptoCurrencyResponse.builder().cryptoId(cryptoCurrency.getCryptoId()).currencyId(cryptoCurrency.getCurrencyId()).cryptoId(cryptoCurrency.getCryptoId()).pair(cryptoCurrency.getPair()).lastTradingPrice(cryptoCurrency.getLastTradingPrice()).previousClose(cryptoCurrency.getPreviousClose()).lastTradingQuantity(cryptoCurrency.getLastTradingQuantity()).cryptoCurrencyId(cryptoCurrency.getCryptoCurrencyId())
                .build();
    }
}
