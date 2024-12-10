package com.nhl.demo.config;


import com.nhl.demo.example.ExampleBean;
import com.nhl.demo.example.MrBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfig {
    
    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }
    
    @Bean
    public MrBean mrBean() {
        return new MrBean(exampleBean());
    }
}
