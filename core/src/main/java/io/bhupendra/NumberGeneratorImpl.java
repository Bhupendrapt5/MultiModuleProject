package io.bhupendra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("numGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

    //---- Fields ---
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private  int maxNumber;


    @Autowired
    @MinNumber
    private  int minNumber;


    //--- public methods ---
    @Override
    public int nextInt() {
        // eg: min=5 max=20 -> max-min = 15 -> range 0-15 + min -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
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
