package net.kelkun.bot.rpKiller;

import net.kelkun.bot.rpKiller.internal.BotManager;

import java.util.Scanner;

/**
 * test class wil be replace by controller
 */
public class Main {

    /**
     * Main for test
     * @param args
     */
    public static void main (String[] args){
        Scanner entry = new Scanner(System.in);
        /*
        System.out.println("wait for token : ");
        BotManager botManager = new BotManager(entry.nextLine());
        */
        BotManager botManager = new BotManager("MzU3MjgwNzI3MTQzOTQwMTA3.DKakxg.nRXW7EYwRipSRaj_Cml5v-yBXJA");
        botManager.startBot();
    }
}
