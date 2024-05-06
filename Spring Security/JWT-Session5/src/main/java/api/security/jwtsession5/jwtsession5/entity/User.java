package api.security.jwtsession5.jwtsession5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private  String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
