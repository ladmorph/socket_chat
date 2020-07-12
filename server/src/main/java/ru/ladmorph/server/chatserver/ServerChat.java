package ru.ladmorph.server.chatserver;

import lombok.extern.slf4j.Slf4j;
import ru.ladmorph.server.clienthandler.ServerChatClientHandler;
import ru.ladmorph.server.config.ServerChatCfg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * The server chat
 */
@Slf4j
public class ServerChat {

    private final ServerChatCfg cfg;
    private ServerSocket serverSocket;

    private final Set<ServerChatClientHandler> clients = new HashSet<>();

    public ServerChat(ServerChatCfg cfg) {
        this.cfg = cfg;
    }

    public Thread start() {
        Thread startingThread = new Thread(
                () -> {
                    try {
                        serverSocket = new ServerSocket(cfg.getPort());
                        log.info("Server chat starting in {} port", cfg.getPort());
                        while (true) {
                            Socket socketClient = serverSocket.accept();
                            ServerChatClientHandler clientHandler =
                                    new ServerChatClientHandler(this, socketClient);

                            clients.add(clientHandler);
                            new Thread(clientHandler).start();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        startingThread.start();
        return startingThread;
    }

    /**
     * The getter method.
     *
     * @return all clients
     */
    public Set<ServerChatClientHandler> getClients() {
        return clients;
    }
}
