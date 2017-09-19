package net.kelkun.bor.rpKiller;

import net.kelkun.bor.rpKiller.internal.BotManager;

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
        System.out.println("wait for token : ");
        BotManager botManager = new BotManager(entry.nextLine());

        botManager.startBot();
    }
}
