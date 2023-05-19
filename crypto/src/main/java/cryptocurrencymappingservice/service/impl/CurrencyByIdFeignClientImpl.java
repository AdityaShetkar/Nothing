package cryptocurrencymappingservice.service.impl;

import cryptocurrencymappingservice.constants.ConstantUtils;
import cryptocurrencymappingservice.domain.response.BaseResponse;
import cryptocurrencymappingservice.exception.NotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CurrencyByIdFeignClientImpl {


    private final CurrencyByCurrencyIdFeignClient currencyByIdFeignClient;

    public BaseResponse CurrencyByIdFeignClient(UUID id){
        try{
            return currencyByIdFeignClient.findByCurrencyId(id).getBody();

        }
        catch (FeignException exception){
            throw new NotFoundException(ConstantUtils.INVALID_CURRENCY);
        }
    }


}
