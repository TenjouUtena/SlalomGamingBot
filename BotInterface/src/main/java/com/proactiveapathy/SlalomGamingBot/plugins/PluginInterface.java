package com.proactiveapathy.SlalomGamingBot.plugins;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;

public interface PluginInterface {
    void init();

    void setInterface(BotInterface bi);

    Boolean wantsMessage(DiscordMessage mess);
    void processMessage(DiscordMessage mess);
}
