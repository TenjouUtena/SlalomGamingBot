package com.proactiveapathy.SlalomGamingBot.plugins;

import com.proactiveapathy.SlalomGamingBot.BotInterface;
import com.proactiveapathy.SlalomGamingBot.DiscordMessage;

public interface PluginInterface {
    void getBotInstance(BotInterface theBot);
    Boolean isProcessMessage();
    void processMessage(DiscordMessage mess);
}
