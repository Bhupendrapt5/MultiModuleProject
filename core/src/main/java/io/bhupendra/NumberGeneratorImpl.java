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

    //--- public methods ---
    @Override
    public int nextInt() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
