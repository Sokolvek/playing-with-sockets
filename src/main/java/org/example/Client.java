package org.example;

import java.io.*;
import java.net.Socket;

class Client {
    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedReader in;
    private BufferedWriter out;

    public Client() throws IOException {
        clientSocket = new Socket("localhost", 8080);
        reader = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        System.out.println("What do you want to say? Enter it here:");
        String word = reader.readLine();
        out.write(word + "\n");
        out.flush();
        String serverWord = in.readLine();
        System.out.println(serverWord);

        clientSocket.close();
        in.close();
        out.close();
    }
}