package ru.ladmorph.server.config;

/**
 * Config for server chat
 */
public class ServerChatCfg implements ServerCfg {

    /**
     * The default port
     */
    private int port = 8080;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
