package io.bhupendra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class GameImpl implements Game {

    //--- Constants ---
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    //--- fields ---
    @Autowired
    private NumberGenerator numberGenerator;

    @Autowired
    @GuessCount
    private int guessCount;

    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuess;
    private boolean validNumberRange = true;

    // --- init method ---
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuess = guessCount;
        largest = numberGenerator.getMaxNumber();
        number = numberGenerator.nextInt();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game Pre-Destroy");
    }

    //--- public classes ----

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public int setGuess(int guess) {
        return this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return largest;
    }

    @Override
    public int getRemainingGuess() {
        return remainingGuess;
    }

    @Override
    public int getGuessCount() {
        return guessCount ;
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if(isValidNumberRange()){
            if(guess > number){
                largest = guess -1;
            }

            if (guess < number){
                smallest = guess + 1;
            }
        }

        remainingGuess--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess==number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuess <=0;
    }

    //--- private method ---

    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess<=largest);
    }
}
