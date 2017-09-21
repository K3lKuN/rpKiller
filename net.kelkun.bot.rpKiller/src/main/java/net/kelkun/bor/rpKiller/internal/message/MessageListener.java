package net.kelkun.bor.rpKiller.internal.message;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class MessageListener implements EventListener{


    public void onEvent(Event event) {
        if(event instanceof MessageReceivedEvent){
            onMessage((MessageReceivedEvent) event);
        }
    }

    private void onMessage(MessageReceivedEvent event){
        System.out.println(event.getMessage().getContent());
        event.getMessage().delete().submit();
    }
}
