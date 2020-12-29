package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
    
    // == fields ==
    private NumberGenerator numberGenerator;
    @Autowired
    @GuessCount
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;
    
    // == constructors == (commented out to use setter-based DI instead)
    @Autowired
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    
    // == init
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        number = numberGenerator.next();
        log.debug("GameImpl @PostConstruct called");
        log.debug("The number is {}", number);
    }
    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }
    
    // == public methods == (commented out to use @Autowiring annotation)
//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
    
    
    public int getGuessCount() {
        return guessCount;
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public int getGuess() {
        return guess;
    }
    
    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }
    
    @Override
    public int getSmallest() {
        return smallest;
    }
    
    @Override
    public int getBiggest() {
        return biggest;
    }
    
    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }
    
    @Override
    public boolean getValidNumberRange() {
        return validNumberRange;
    }
    
    @Override
    public void check() {
        if(isValidNumberRange()){
            if(guess > number){
                biggest = guess -1;
            }
            if (guess < number) {
                smallest = guess +1;
            }
        }
        remainingGuesses--;
    
    }
    
    @Override
    public boolean isValidNumberRange() {
        return validNumberRange = (guess >= smallest) && (guess <=biggest);
    }
    
    @Override
    public boolean isGameWon() {
        return guess == number;
    }
    
    @Override
    public boolean isGameLost() {
        return !isGameWon() && (remainingGuesses <= 0);
    }
    
}













