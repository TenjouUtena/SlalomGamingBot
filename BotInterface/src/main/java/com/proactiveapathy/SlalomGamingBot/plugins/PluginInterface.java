package com.proactiveapathy.SlalomGamingBot.plugins;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public interface PluginInterface {
    void init();

    void setInterface(BotInterface bi);

    Boolean wantsMessage(DiscordMessage mess);
    void processMessage(DiscordMessage mess);

    Boolean wantsEvent(Class<? extends Event> type);
    void processEvent(Event evt);

}
