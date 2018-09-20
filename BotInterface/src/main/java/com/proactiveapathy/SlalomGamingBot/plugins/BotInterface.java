package com.proactiveapathy.SlalomGamingBot.plugins;

import java.util.Map;

public interface BotInterface {

    String getIni(String section, String key);
    public Map<String, String> getIniMap(String section);

}
