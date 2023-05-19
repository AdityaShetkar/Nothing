package cryptocurrencymappingservice.securityConfig;

import cryptocurrencymappingservice.constants.ConstantUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extactAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    public  String generateToken(Map<String, Object> extraclaims, UserDetails userDetails){
        return buildToken(extraclaims,userDetails);
    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    private String  buildToken(Map<String, Object> extraclaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extraclaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +  1000 * 60 * 24))
                .signWith(getSignkey(), SignatureAlgorithm.HS256).compact();
    }

    public Boolean isTokenValid(String token , UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !tokenExpired(token);
    }

    private boolean tokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extactAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignkey()).build().parseClaimsJws(token).getBody();
    }
    private Key getSignkey(){
        byte[] keyBytes = Decoders.BASE64.decode(ConstantUtils.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
