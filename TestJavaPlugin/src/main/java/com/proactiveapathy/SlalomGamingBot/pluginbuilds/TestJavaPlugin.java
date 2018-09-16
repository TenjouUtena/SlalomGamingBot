package com.proactiveapathy.SlalomGamingBot.pluginbuilds;


import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.BotInterface;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;

public class TestJavaPlugin implements PluginInterface {

    private BotInterface bot;

    @Override
    public void setInterface(BotInterface bi) {
        bot = bi;
    }

    @Override
    public void init() {
        // Do Nothing.
    }

    @Override
    public Boolean wantsMessage(DiscordMessage mess) {
        return mess.getMessageString().toLowerCase().startsWith("!test");
    }

    @Override
    public void processMessage(DiscordMessage mess) {
        System.out.println("TestMessageFromJava: " + mess.getMessageString());
        mess.getMessageChannel().sendMessage("Test from Java!").queue();
    }
}
