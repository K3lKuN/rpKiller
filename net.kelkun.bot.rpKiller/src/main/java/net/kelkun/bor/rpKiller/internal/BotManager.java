package net.kelkun.bor.rpKiller.internal;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.kelkun.bor.rpKiller.internal.message.MessageListener;

public class BotManager extends ListenerAdapter{
    String token;
    private JDA jda;
    MessageListener messageListener;

    public BotManager(String token){
        this.token = token;
    }

    BotManager(){

    }

    /**
     * start bot
     * @return
     *  <li>True if connect is valid</li>
     *  <li>False if failed</li>
     */
    public boolean startBot(){
        try{
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .setBulkDeleteSplittingEnabled(false)
                    .buildBlocking();
            jda.addEventListener(new MessageListener());
            return true;
        }catch(Exception e){
            System.out.println("error during the connection : "+e);
            return false;
        }
    }

    //Listener
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println(event.getMessage());
    }

    //Getter
    public JDA getJda() {
        return jda;
    }
}
