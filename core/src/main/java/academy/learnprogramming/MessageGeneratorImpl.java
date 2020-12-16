package academy.learnprogramming;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{
    
    // == constants ==
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    
    // fields
    @Autowired
    private Game game;
    private int guessCount = 10;
    
    @PostConstruct
    private void postConstruct(){
        log.info("postConstruct called for MessageGeneratorImpl");
        log.info("Game = " + game);
    }
    
    // public methods
    @Override
    public String getMainMessage() {
        return "getMainMessage called";
    }
    
    @Override
    public String getResultMessage() {
        return "getResultMessage called";
    }
}
