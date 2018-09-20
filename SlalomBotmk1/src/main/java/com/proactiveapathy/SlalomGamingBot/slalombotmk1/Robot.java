package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.reflections.Reflections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Robot {


    public static void main(String[] args) throws Exception {

        Set<PluginInterface> plugins;


        // Get token
        String token = "";
        try {
            token = new String(Files.readAllBytes(Paths.get("token")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        token = token.replace(" ","").replace("\n","").replace("\r","");

        // Create bot services object
        SlalomBotInterface bot = new SlalomBotInterface();
        bot.init();

        // Build JDA
        JDA jda = new JDABuilder(AccountType.BOT).setToken(token).build();

        // Build Plugins

        Reflections reflections = new Reflections("com.proactiveapathy.SlalomGamingBot");
        plugins = new HashSet<PluginInterface>();

        for(Class<? extends PluginInterface> cls : reflections.getSubTypesOf(PluginInterface.class)) {
            System.out.println("Found: " + cls.getName());
            PluginInterface n = cls.newInstance();
            n.setInterface(bot);
            n.init();
            plugins.add(n);
        }


        jda.addEventListener(new BotEventHandler(plugins));


    }
}
