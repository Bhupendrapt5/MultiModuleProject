package io.bhupendra;

import io.bhupendra.config.AppConfig;
import io.bhupendra.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main  {
    public final static Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number");

        // Create Context (Container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class );

        // Note : AppConfig is not needed anymore. We can delete it.

//
//        // get the numberGenerator bean from context (Container)
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        // Call method next() to get random number
//        int number = numberGenerator.nextInt();
//
//        // Log generated number
//        log.info("number = {}", number);
//
//        // get the game bean from context (Container)
//        Game game = context.getBean(Game.class);
//
//        // get the MessageGenerator bean
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//
//        log.info("get mainMessage ==> {}",messageGenerator.getMainMessage());
//        log.info("get resultMessage ==> {}",messageGenerator.getResultMessage());
//


        //close context {container}
        context.close();
     }
}

