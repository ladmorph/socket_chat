package ru.ladmorph.server.formatter;

/**
 * Message formatter for server chat
 */
public class ServerChatMessageFormatter implements MessageFormatter {

    @Override
    public String format(String message) {
        int idx = message.indexOf(':');
        return message.substring(idx + 2);
    }
}
