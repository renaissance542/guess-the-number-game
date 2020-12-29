package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
    
    // == fields ==
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;
    
    // == constructors ==
    
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }
    
    // == init
    @PostConstruct
    public void init() {
        log.debug("NumberGeneratorImpl @PostConstruct called");
    }
    
    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber+minNumber)-minNumber;
    }
    
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
    
    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
