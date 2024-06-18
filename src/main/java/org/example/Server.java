package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server implements Runnable {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public Server() throws IOException {
        serverSocket = new ServerSocket(8080);
        System.out.println("Server started");
    }

    @Override
    public void run() {
        try {
            socket = serverSocket.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String word = in.readLine();
            System.out.println(word);

            out.write("What is this " + word + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}