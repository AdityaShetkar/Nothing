package cryptocurrencymappingservice.service.impl;

import cryptocurrencymappingservice.constants.ConstantUtils;
import cryptocurrencymappingservice.domain.response.BaseResponse;
import cryptocurrencymappingservice.exception.NotFoundException;
import cryptocurrencymappingservice.service.CryptoByIdFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CryptoByIdFeignClientImpl {

    private final CryptoByIdFeignClient cryptoByIdFeignClient;

    public BaseResponse CryptoByIdFeignClient(UUID id) {
        try {
            return cryptoByIdFeignClient.findByCryptoCurrencyId(id).getBody();

        } catch (FeignException exception) {
            throw new NotFoundException(ConstantUtils.INVALID_CRYPTO);
        }
    }
}
