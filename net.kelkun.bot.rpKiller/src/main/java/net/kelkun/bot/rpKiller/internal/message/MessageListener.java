package net.kelkun.bot.rpKiller.internal.message;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.kelkun.bot.rpKiller.internal.listener.MessageDeleteEventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageListener implements EventListener{
    private static Pattern pattern = Pattern.compile("^\\(+((\\w|\\W)*)+\\)+$");
    private static Pattern commandPattern = Pattern.compile("^(::)");
    private static Matcher matcher;
    private ComandLine comandLine = new ComandLine();


    public void onEvent(Event event) {
        if(event instanceof MessageReceivedEvent){
            onMessage((MessageReceivedEvent) event);
        }
    }

    private void onMessage(MessageReceivedEvent event){

        matcher = pattern.matcher(event.getMessage().getContent());
        if(matcher.find()){
            System.out.println("Message va être supprimé : "+event.getMessage().getContent());
            DeleteMessage deleteMessage = new DeleteMessage(event);

            final ScheduledExecutorService deleteTimer = Executors.newScheduledThreadPool(1);
            deleteTimer.scheduleAtFixedRate(deleteMessage, 8, 15, TimeUnit.MINUTES);

            deleteMessage.addMessageDeleteEventListener(new MessageDeleteEventListener() {
                public void messageDelete() {
                    System.out.println("Message supprimé correctement");
                    try{
                        deleteTimer.shutdown();
                    }catch (Exception e){
                        System.out.println("Impossible de détruire le timer : "+e);
                    }
                }
            });
        }

        matcher = commandPattern.matcher(event.getMessage().getContent());
        if(matcher.find()){
            System.out.println("comand line on "+event.getMessage().getChannel()+" comand : "+event.getMessage().getContent());
            comandLine.process(event);
        }
    }
}
