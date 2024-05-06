package api.security.jwtsession5.jwtsession5.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/test/home")
    public ResponseEntity home(){
        return ResponseEntity.ok("hello !");
    }
}

