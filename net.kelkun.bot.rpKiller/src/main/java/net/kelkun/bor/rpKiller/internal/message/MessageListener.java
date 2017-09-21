package net.kelkun.bor.rpKiller.internal.message;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageListener implements EventListener{
    //private Logger logger = LoggerFactory.getLogger(getClass());
    private static Pattern pattern = Pattern.compile("\\(+((\\w|\\W)*)+\\)");
    private static Matcher matcher;


    public void onEvent(Event event) {
        if(event instanceof MessageReceivedEvent){
            onMessage((MessageReceivedEvent) event);
        }
    }

    private void onMessage(MessageReceivedEvent event){
        //logger.info("Message {} entrant", event.getMessage().getContent());

        matcher = pattern.matcher(event.getMessage().getContent());
        if(matcher.find()){
            System.out.println("Message va être supprimé");
            //logger.info("Le message va être supprimé");
            final ScheduledExecutorService deleteTimer = Executors.newScheduledThreadPool(1);
            deleteTimer.scheduleAtFixedRate(new DeleteMessage(event), 8, 15, TimeUnit.MINUTES);
            //logger.info("Message supprimé");
        }
    }
}
