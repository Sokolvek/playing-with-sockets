package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public record Request(String url) {

    public void get(String endpoint) throws IOException {
        Socket socket = new Socket(this.url, 80);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET " + endpoint + " HTTP/1.1");
        out.println("Host: example.com");
        out.println();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
                out.println("hello");
            }
        };
        timer.scheduleAtFixedRate(task, new Date().getSeconds()+1, 1000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }


    }



}
