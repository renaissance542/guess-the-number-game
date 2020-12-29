package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    
    public static void main(String[] args) {
        log.info("Guess the Number Game");
        
        // create context (container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        // close the context (container)
        context.close();
    }
    
}














