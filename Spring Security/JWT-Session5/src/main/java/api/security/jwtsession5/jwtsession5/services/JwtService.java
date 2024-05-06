package api.security.jwtsession5.jwtsession5.services;

import api.security.jwtsession5.jwtsession5.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
public class JwtService {
    private final String secretKey ="mySecretKey";
    private final String TOKEN_HEADER="Authrization";
    private final String TOKEN_PREFIX="Bearer ";
    private final long accessTokenValidity = 60*60*1000; //for an hour

    public String createToken(User user){
        Claims claims  = Jwts.claims();
        // your custom claims in payLoad part of JWT
        claims.put("firstname",user.getFirstName());
        claims.put("lastname",user.getLastName());

        //Token time
        Date creationDate = new Date();
        Date tokenVaildity = new Date(creationDate.getTime()+ TimeUnit.MINUTES.toMillis(accessTokenValidity));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())  //mandatory to whom you refere
                .setExpiration(tokenVaildity)
                .signWith(SignatureAlgorithm.HS256 ,secretKey) // last part of JWT => Signature
                .compact();
    }

    // parse token --> claims
    private JwtParser jwtParser;
    public Claims parseJwtClaims(String token){
        return  jwtParser.parseClaimsJwt(token).getBody();

    }

    public String  retreiveToken(HttpServletRequest request){
        String authHeader = request.getHeader(TOKEN_HEADER);
        if(authHeader != null && authHeader.startsWith(TOKEN_PREFIX)){
            return authHeader.substring(TOKEN_PREFIX.length());
        }
        return null ;

    }

    public Claims  retreiveJwtClaims(HttpServletRequest request){
        try {
            String token = retreiveToken(request);
            if(token !=null){
                return parseJwtClaims(token);
            }

           return null ;
        }catch (Exception e){
            request.setAttribute("Invalid",e.getMessage());
            throw  e;
        }
    }
    public boolean isTokenExpired(Date expire){
        try{
         return  expire.before(new Date());
        }catch (Exception e){
            throw e;
        }

    }



}
