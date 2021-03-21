package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    // == constants ==
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String RESULT_WON = "game.win";
    public static final String RESULT_LOST = "game.lost";
    public static final String INVALID_NUMBER = "game.invalid.number";
    public static final String FIRST_GUESS = "game.first.guess";
    public static final String GUESS_LOWER = "game.lower";
    public static final String GUESS_HIGHER = "game.higher";
    public static final String GUESSES_REMAINING = "game.guesses.remaining";
    
    // fields
    private final Game game;
    private final MessageSource messageSource;
    
    // == constructors ==
    
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }
    
    // init method
    @PostConstruct
    private void postConstruct() {
        log.info("postConstruct called for MessageGeneratorImpl");
        log.info("Game = {}", game);
    }
    
    // public methods
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
    
    }
    
    @Override
    public String getResultMessage() {
        log.info("getNumber() = {}", game.getNumber());
        if(game.isGameWon()){
            return getMessage(RESULT_WON, game.getNumber());
        } else if (game.isGameLost()) {
            return getMessage(RESULT_LOST, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID_NUMBER);
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        } else {
            String direction = getMessage(GUESS_LOWER);
            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(GUESS_HIGHER);
            }
            return direction + " " +
                    getMessage(GUESSES_REMAINING, game.getRemainingGuesses());
        }
    }
    
    // == private methods ==
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
