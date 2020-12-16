package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
    
    // == fields ==
    private final Random random = new Random();
    private int maxNumber = 100;
    
    // == init
    @PostConstruct
    public void init() {
        log.debug("NumberGeneratorImpl @PostConstruct called");
    }
    
    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }
    
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
