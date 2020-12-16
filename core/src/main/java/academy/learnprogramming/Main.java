package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    
    public static void main(String[] args) {
        log.info("Guess the Number Game");
        
        // create context (container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        // get numberGenerator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);
        
        // call method next() to get a random number
        int number = numberGenerator.next();
        
        // log generated number
        log.info("number = {}", number);
        
        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // (old) call reset method (new -> switch to init() method called by spring container
//        game.reset();
        
        // get messageGenerator bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        
        // call messageGenerator methods
        System.out.println("******* " + messageGenerator.getMainMessage());
        System.out.println("******* " + messageGenerator.getResultMessage());
        
        // close the context (container)
        context.close();
    }
    
}














