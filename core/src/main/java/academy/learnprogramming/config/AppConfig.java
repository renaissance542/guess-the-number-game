package academy.learnprogramming.config;

import academy.learnprogramming.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {
    
    // bean methods
    
    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }

}
