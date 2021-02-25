package academy.learnprogramming.controller;

import academy.learnprogramming.service.GameService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.GameMappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {
    
    // == fields ==
    private final GameService gameService;
    
    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    // == request methods ==
    
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        model.addAttribute("PLAY", ViewNames.PLAY);
        model.addAttribute("MAIN_MESSAGE", AttributeNames.MAIN_MESSAGE);
        model.addAttribute("RESULT_MESSAGE", AttributeNames.RESULT_MESSAGE);
        log.info("model = {}", model);
        if (gameService.isGameOver()) {
            return "redirect:/" + ViewNames.GAME_OVER;
        } else {
            return ViewNames.PLAY;
        }
    }
    
    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        gameService.checkGuess(guess);
        log.info("guess = {}", guess);
        return GameMappings.REDIRECT_PLAY;
    }
    
    @GetMapping(GameMappings.GAME_OVER)
    public String gameOver(Model model) {
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        model.addAttribute("RESULT_MESSAGE", AttributeNames.RESULT_MESSAGE);
        model.addAttribute("PLAY", ViewNames.PLAY);
        gameService.reset();
        log.info("gameService.reset() was called");
        return ViewNames.GAME_OVER;
    }
}














