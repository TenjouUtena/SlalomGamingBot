package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class BotEventHandler extends ListenerAdapter {

    private Set<PluginInterface> plugins;

    public BotEventHandler(Set<PluginInterface> p) throws Exception {
        plugins = p;
    }


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
        for(PluginInterface p : plugins)
            if(p.wantsEvent(event.getClass()))
                p.processEvent(event);
    }

    public void onMessageReceived(MessageReceivedEvent event)
    {
        DiscordMessage mess = new DiscordMessage(event.getMessage());
        for(PluginInterface p : plugins)
            if(p.wantsMessage(mess))
                p.processMessage(mess);

    }

}
