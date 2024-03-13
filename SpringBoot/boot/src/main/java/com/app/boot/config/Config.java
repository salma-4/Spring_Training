package com.app.boot.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@ConfigurationProperties(prefix = "myapp") //all in small
//==>
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Config {
    private String name;
    private Description description;
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class Description{
        // why static ==> in memory and all object refere to it "no change"

        private  String title;
        private String  fullDescription;
    }


}
