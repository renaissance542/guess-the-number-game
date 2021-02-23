package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
    
    // == fields ==
    private Game game;
    private MessageGenerator messageGenerator;
    
    // == constructors ==
    // Tim made this constructor public, and had @Autowired annotated for the whole constructor, not individual
    // variables.
    private GameServiceImpl(@Autowired Game game, @Autowired MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    
    
    // init
    @PostConstruct
    private void init() {
        log.info("Main Message = {}, Number to guess = {}", messageGenerator.getMainMessage(), game.getNumber());
    }
    
    // == methods ==
    
    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();
    }
    
    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }
    
    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }
    
    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }
    
    @Override
    public void reset() {
        game.reset();
    }
    
    
}
