package api.security.jwtsession5.jwtsession5.controller;

import api.security.jwtsession5.jwtsession5.entity.User;
import api.security.jwtsession5.jwtsession5.model.login.LoginRequest;
import api.security.jwtsession5.jwtsession5.model.login.LoginResponse;
import api.security.jwtsession5.jwtsession5.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
     private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
           String email =authentication.getName();
            User user = new User(email,"");
            String token = jwtService.createToken(user);
            LoginResponse loginResponse = new LoginResponse(email,token);
            return ResponseEntity.ok(loginResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
