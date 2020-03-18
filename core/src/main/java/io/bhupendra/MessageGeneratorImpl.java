package io.bhupendra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == Constants ==
    public static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //=== Fields ===
    @Autowired
    private Game game;
//    private int guessCount = 10;

    // === init ===
    @PostConstruct
    public void init(){

        log.info("game ==> {}", game);
    }


    // === Public Methods ====

    @Override
    public String getMainMessage() {
        return "Number is between "+
                game.getSmallest()+
                " and "+
                game.getBiggest()+
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "Congratulation..!!!\n you have guessed it right." +
                    " The number was "+game.getNumber();
        }
        else if(game.isGameLost()){
            return "You lost :( .. The number was"+game.getNumber();
        }
        else if(!game.isValidNumberRange()){
            return "not valid range";
        }
        else if(game.getRemainingGuess() == game.getGuessCount()){
            return "What is your first guess? ";
        }
        else{
            String range = "Lower";
            if(game.getNumber() > game.getGuess()){
                range = "higher";
            }

            return range+"! you have "+ game.getRemainingGuess()+" attempts left.";
        }
    }
}
