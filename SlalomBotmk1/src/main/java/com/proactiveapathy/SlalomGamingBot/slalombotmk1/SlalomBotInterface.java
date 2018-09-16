package com.proactiveapathy.SlalomGamingBot.slalombotmk1;

import com.proactiveapathy.SlalomGamingBot.plugins.BotInterface;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class SlalomBotInterface implements BotInterface {

    private Ini ini;

    public SlalomBotInterface() {

    }

    public void init() {

        try {
            ini = new Ini(new File("bot.ini"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(5);
        }

    }

    @Override
    public String getIni(String section, String key) {
        return ini.get(section, key);
    }
}
