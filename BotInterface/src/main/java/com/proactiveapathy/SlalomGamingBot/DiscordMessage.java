package com.proactiveapathy.SlalomGamingBot;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class DiscordMessage {
    public DiscordMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {return this.message;}
    public MessageChannel getMessageChannel() { return this.message.getChannel(); }

    public String getMessageString() { return message.getContentDisplay(); }
    public String getChannelString() {
        return message.getAuthor().toString();
    }
    public String getUserString() {
        return message.getTextChannel().toString();
    }




    Message message;
}
