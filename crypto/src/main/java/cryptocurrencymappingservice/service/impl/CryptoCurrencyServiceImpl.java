package cryptocurrencymappingservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cryptocurrencymappingservice.constants.ConstantUtils;
import cryptocurrencymappingservice.domain.request.CreateCryptoCurrencyDto;
import cryptocurrencymappingservice.domain.request.CryptoRequestDto;
import cryptocurrencymappingservice.domain.request.CurrencyRequestDto;
import cryptocurrencymappingservice.domain.response.BaseResponse;
import cryptocurrencymappingservice.domain.response.CryptoCurrencyResponse;
import cryptocurrencymappingservice.entity.CryptoCurrency;
import cryptocurrencymappingservice.exception.AlreadyPresentException;
import cryptocurrencymappingservice.exception.NotFoundException;
import cryptocurrencymappingservice.helper.CryptoCurrencyHelper;
import cryptocurrencymappingservice.repository.CryptoCurrencyRepository;
import cryptocurrencymappingservice.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    private final CryptoCurrencyRepository cryptoCurrencyRepository;


    private final ObjectMapper objectMapper;
    private final CurrencyByIdFeignClientImpl currencyByIdFeignClient;
    private final CryptoByIdFeignClientImpl cryptoByIdFeignClient;


    @Override
    public BaseResponse saveCryptoCurrency(CreateCryptoCurrencyDto createCryptoCurrencyDto) throws JsonProcessingException {

        CryptoRequestDto cryptoRequestDto = verifyCrypto(createCryptoCurrencyDto.getCryptoId());
        if (cryptoRequestDto.getId() == null) {
            throw new NotFoundException(ConstantUtils.INVALID_CURRENCY);
        }
        CurrencyRequestDto currencyRequestDto = verifyCurrency(createCryptoCurrencyDto.getCurrencyId());
        log.info("get currency" + currencyRequestDto);
        UUID currencyid = cryptoCurrencyRepository.findByCurrencyIdByCrypto(createCryptoCurrencyDto.getCurrencyId());
        if (currencyid == null) {
            throw new AlreadyPresentException(ConstantUtils.CURRENCY_ALREADY_MAPPED);
        }
        CryptoCurrency cryptoCurrency = CryptoCurrencyHelper.entitytoDto(createCryptoCurrencyDto);
        cryptoCurrencyRepository.save(cryptoCurrency);
        log.info("successfully added crypto with currency" + currencyRequestDto);
        CryptoCurrencyResponse response = CryptoCurrencyHelper.buildResponseFromEntity(cryptoCurrency);




        return new BaseResponse(HttpStatus.OK.value(), ConstantUtils.CURRENCY_CRYPTO_MAPPED_SUCCESSFULLY, null, response);
    }



    @Override
    public ResponseEntity<BaseResponse> findCryptoCurrency(UUID userId) {
        return null;
    }

    @Override
    public BaseResponse findCryptoCurrencyByCryptoCurrencyId(UUID cryptoCurrencyId) {
        Optional<CryptoCurrency> cryptoCurrency = cryptoCurrencyRepository.findByCryptoCurrencyId(cryptoCurrencyId);
        if (!cryptoCurrency.isPresent()){
            throw new NotFoundException(ConstantUtils.CRYPTO_CURRENCY_NOT_MAPPED);
        }
        CryptoCurrencyResponse currencyResponse = CryptoCurrencyHelper.buildResponseFromEntity(cryptoCurrency.get());
        log.info("crypto currency details "+currencyResponse);
        return new BaseResponse(HttpStatus.FOUND.value(),ConstantUtils.CRYPTO_CURRENCY_RETRIEVED_SUCCESSFULLY,null, currencyResponse);
    }

    @Override
    public BaseResponse updateLastTradingPriceandQuantityByCryptoCurrencyId(UUID cryptoCurrencyId, BigDecimal lastTradingPrice, BigDecimal quantity) {
        Optional<CryptoCurrency> cryptoCurrencyDetails = cryptoCurrencyRepository.findByCryptoCurrencyId(cryptoCurrencyId);
        if (!cryptoCurrencyDetails.isPresent()) {
            throw new NotFoundException(ConstantUtils.CRYPTO_CURRENCY_NOT_FOUND);
        }
        cryptoCurrencyDetails.get().setLastTradingPrice(lastTradingPrice);
        cryptoCurrencyDetails.get().setLastTradingQuantity(quantity);
        cryptoCurrencyRepository.save(cryptoCurrencyDetails.get());
        CryptoCurrencyResponse currencyResponse = CryptoCurrencyHelper.buildResponseFromEntity(cryptoCurrencyDetails.get());
        return new BaseResponse(HttpStatus.FOUND.value(), ConstantUtils.CRYPTO_CURRENCY_RETRIEVED_SUCCESSFULLY,currencyResponse,null);
    }

    private CurrencyRequestDto verifyCurrency(UUID currencyId) throws JsonProcessingException {

        BaseResponse baseResponse = currencyByIdFeignClient.CurrencyByIdFeignClient(currencyId);
        String value = objectMapper.writeValueAsString(baseResponse.getData());
        CurrencyRequestDto currencyRequestDto = objectMapper.readValue(value, CurrencyRequestDto.class);
        log.info("Currency details" + currencyRequestDto);
        return currencyRequestDto;

    }

    private CryptoRequestDto verifyCrypto(UUID cryptoId) throws JsonProcessingException {

        BaseResponse baseResponse = cryptoByIdFeignClient.CryptoByIdFeignClient(cryptoId);
        String value = objectMapper.writeValueAsString(baseResponse.getData());
        CryptoRequestDto cryptoRequestDto = objectMapper.readValue(value, CryptoRequestDto.class);
        log.info("Crypto  details" + cryptoRequestDto);
        return cryptoRequestDto;

    }


}
