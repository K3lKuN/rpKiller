package net.kelkun.bot.rpKiller.internal.message;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.kelkun.bot.rpKiller.internal.listener.MessageDeleteEventListener;

public class DeleteMessage implements Runnable {

    private final MessageReceivedEvent message;
    private MessageDeleteEventListener messageDeleteEventListener;

    DeleteMessage(MessageReceivedEvent message){
        this.message = message;
    }
    public void run() {
        try{
            message.getMessage().delete().submit();
            fireMessageDelete();
        }catch (Exception e){
            System.out.println("impossible de supprimer le message : "+e);
        }
    }

    //Listener
    public void addMessageDeleteEventListener(MessageDeleteEventListener messageDeleteEventListener){
        this.messageDeleteEventListener = messageDeleteEventListener;
    }

    private void fireMessageDelete(){
        this.messageDeleteEventListener.messageDelete();
    }
}
