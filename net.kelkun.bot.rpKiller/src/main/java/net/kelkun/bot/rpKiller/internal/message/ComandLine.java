package net.kelkun.bot.rpKiller.internal.message;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ComandLine {
    final static String HELP = "::help";

    public void process(MessageReceivedEvent event) {
        if(event.getMessage().getContent().toString().equals(HELP)){
            event.getChannel().sendMessage("Pour le moment l'aide n'est pas disponible").submit();
        }
    }
}
