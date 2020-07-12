package ru.ladmorph.server;

import ru.ladmorph.server.chatserver.ServerChat;
import ru.ladmorph.server.config.ServerChatCfg;

/**
 * The main class
 */
public class Main {

    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat(new ServerChatCfg());
        serverChat.start();
    }
}
