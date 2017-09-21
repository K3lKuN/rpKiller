package net.kelkun.bor.rpKiller.internal.message;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class DeleteMessage implements Runnable {

    private final MessageReceivedEvent message;

    DeleteMessage(MessageReceivedEvent message){
        this.message = message;
    }
    public void run() {
        message.getMessage().delete().submit();
        System.out.println("Message supprimé");
    }
}
