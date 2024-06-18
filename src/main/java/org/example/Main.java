package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Http http = new Http("example.com");
//        http.get("/");

        try {
            Server server = new Server();
            Thread serverThread = new Thread(server);
            serverThread.start();


            Client client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        InetAddress domains[] = InetAddress.getAllByName("www.youtube.com");
//        URL url = new URL("https://www.geeksforgeeks.org");
//        System.out.println(url);
//
//        for(var item : domains){
//            System.out.println(item);
//        }
//        Socket socket = null;
//        int c;
//        int port = 80;
//        for(int i = 79; i < 90; i++){
//            System.out.println("try " + i);
//            try{
//                socket = new Socket("www.youtube.com", port);
//            }catch (Exception e){
//                System.out.println("fail " + i);
//            }
//            assert socket != null;
//            if(socket.isConnected()) break;
//        }
//        System.out.println(socket.isConnected());
//
//        System.out.println("first");
//        InputStream inputStream = socket.getInputStream();
//        OutputStream outputStream = socket.getOutputStream();
//        System.out.println("second");
//        String str = "osborne.com";
//
//        byte buf[] = str.getBytes();
//
//        outputStream.write(buf);
//        System.out.println("third");
//        while((c = inputStream.read()) != -1){
//            System.out.println((char)c);
//        }
//        socket.close();
//        System.out.println("closed");
    }
}