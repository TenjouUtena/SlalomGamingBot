package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Robot {

    public static void main(String[] args) throws Exception {
        // Get token
        String token = "";
        try {
            token = new String(Files.readAllBytes(Paths.get("token")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        token = token.replace(" ","").replace("\n","").replace("\r","");


        JDA jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
        jda.addEventListener(new OnBotMessage());


    }
}
