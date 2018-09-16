package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class OnBotMessage extends ListenerAdapter {

    private Set<PluginInterface> plugins;

    public OnBotMessage(Set<PluginInterface> p) throws Exception {
        plugins = p;
    }



    public void onMessageReceived(MessageReceivedEvent event)
    {
        DiscordMessage mess = new DiscordMessage(event.getMessage());
        for(PluginInterface p : plugins)
            if(p.wantsMessage(mess))
                p.processMessage(mess);

    }

}
