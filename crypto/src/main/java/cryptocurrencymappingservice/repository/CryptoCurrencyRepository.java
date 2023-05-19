package cryptocurrencymappingservice.repository;

import cryptocurrencymappingservice.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, UUID> {

    public Optional<CryptoCurrency> findByCryptoCurrencyId(UUID id);

    @Query(value = "select currency_id from crypto_currency where crypto_id = :crypto_id", nativeQuery = true)
    public UUID findByCurrencyIdByCrypto(@Param("crypto_id") UUID crypto_id);


    public Optional<CryptoCurrency>findByCryptoId(UUID cryptoId);



}
