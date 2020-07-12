package ru.ladmorph.server.clienthandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * The base client handler
 */
public abstract class BaseClientHandler {

    private Scanner scanner;
    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * The constructor.
     *
     * @param socket the client
     * @throws IOException exception
     */
    public BaseClientHandler(Socket socket) throws IOException {
        scanner = new Scanner(socket.getInputStream());
//        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    /**
     * Read message from client.
     *
     * @return message from client
     */
    public String readMessage() {
        String message = null;
        if (scanner.hasNext()) {
            message = scanner.nextLine();
        }
        return message;
    }

    /**
     * Write message to client.
     *
     * @param message to client
     * @throws IOException ex
     */
    public void sendMessage(String message) throws IOException {
        writer.write(message + "\r\n");
        writer.flush();
    }

    public void close() throws IOException {
        this.reader.close();
        this.writer.close();
    }
}
