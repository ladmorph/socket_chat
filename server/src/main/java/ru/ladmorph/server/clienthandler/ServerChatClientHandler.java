package ru.ladmorph.server.clienthandler;

import ru.ladmorph.server.chatserver.ServerChat;
import ru.ladmorph.server.clienthandler.BaseClientHandler;
import ru.ladmorph.server.formatter.ServerChatMessageFormatter;

import java.io.IOException;
import java.net.Socket;

/**
 * Client handler for server chat.
 */
public class ServerChatClientHandler extends BaseClientHandler implements Runnable {

    private ServerChatMessageFormatter messageFormatter;
    private ServerChat serverChat;
    private Socket socket;

    /**
     * The constructor.
     *
     * @param serverChat the server chat
     * @param socket     the client
     * @throws IOException the exception
     */
    public ServerChatClientHandler(ServerChat serverChat, Socket socket) throws IOException {
        super(socket);
        this.serverChat = serverChat;
        this.socket = socket;
        messageFormatter = new ServerChatMessageFormatter();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = readMessage();
                if (message == null || message.isEmpty()) {
                    continue;
                }
                String formattedMessage = messageFormatter.format(message);
                System.out.println(formattedMessage);
                sendMessageToAllClients(message);
            } finally {
                close();
            }
        }
    }

    /**
     * Send message to all clients
     *
     * @param message the message
     */
    private void sendMessageToAllClients(String message) {
        serverChat.getClients().forEach(client -> {
            try {
                client.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Remove client,
     * Close socket,
     * Close IO
     *
     * @throws IOException ex
     */
    public void close() {
        serverChat.getClients().remove(this);
    }
}
