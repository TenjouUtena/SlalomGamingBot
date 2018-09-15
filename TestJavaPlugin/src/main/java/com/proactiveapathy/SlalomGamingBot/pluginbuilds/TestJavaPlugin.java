package com.proactiveapathy.SlalomGamingBot.pluginbuilds;


import com.proactiveapathy.SlalomGamingBot.BotInterface;
import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;

public class TestJavaPlugin implements PluginInterface {
    @Override
    public void getBotInstance(BotInterface theBot) {

    }

    @Override
    public Boolean isProcessMessage(DiscordMessage mess) {
        return mess.getMessageString().toLowerCase().startsWith("!test");
    }

    @Override
    public void processMessage(DiscordMessage mess) {
        System.out.println("TestMessageFromJava: " + mess.getMessageString());
        mess.getMessageChannel().sendMessage("Test from Java!").queue();
    }
}
