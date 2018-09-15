package com.proactiveapathy.SlalomGamingBot.plugins;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;

public interface PluginInterface {
    Boolean wantsMessage(DiscordMessage mess);
    void processMessage(DiscordMessage mess);
}
