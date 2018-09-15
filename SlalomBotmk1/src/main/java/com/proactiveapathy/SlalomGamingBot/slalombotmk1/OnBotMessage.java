package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import com.proactiveapathy.SlalomGamingBot.DiscordMessage;
import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class OnBotMessage extends ListenerAdapter {

    private Set<PluginInterface> plugins;

    public OnBotMessage() throws Exception {
        resyncPlugins();
    }

    private void resyncPlugins() throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("com.proactiveapathy.SlalomGamingBot");
        plugins = new HashSet<PluginInterface>();

        for(Class<? extends PluginInterface> cls : reflections.getSubTypesOf(PluginInterface.class)) {
            System.out.println("Found: " + cls.getName());
            plugins.add(cls.newInstance());
        }
    }


    public void onMessageReceived(MessageReceivedEvent event)
    {
        DiscordMessage mess = new DiscordMessage(event.getMessage());
        for(PluginInterface p : plugins)
            if(p.isProcessMessage(mess))
                p.processMessage(mess);

     /*
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
    */
    }

}
