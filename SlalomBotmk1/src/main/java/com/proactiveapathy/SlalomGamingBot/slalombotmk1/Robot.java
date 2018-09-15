package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Robot {

    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(AccountType.BOT).setToken("").buildBlocking();
        jda.addEventListener(new OnBotMessage());

    }
}
