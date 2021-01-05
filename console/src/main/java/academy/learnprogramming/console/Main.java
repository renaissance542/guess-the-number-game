package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    
    // Below line removed and replaced with class notation @Slf4j from Lombok plugin
//    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        log.info("Guess the Number Game");
        
        // create context (container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(GameConfig.class);
        
        // close the context (container)
        context.close();
    }
    
}














