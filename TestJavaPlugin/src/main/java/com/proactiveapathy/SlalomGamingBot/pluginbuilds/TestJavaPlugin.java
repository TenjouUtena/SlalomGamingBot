package com.proactiveapathy.SlalomGamingBot.pluginbuilds;


import com.proactiveapathy.SlalomGamingBot.BotInterface;
import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;

public class TestJavaPlugin implements PluginInterface {
    @Override
    public void getBotInstance(BotInterface theBot) {

    }

    @Override
    public Boolean isProcessMessage() {
        return true;
    }

    @Override
    public void processMessage(DiscordMessage mess) {
        System.out.println("TestMessageFromJava: " + mess.getMessage());
    }
}