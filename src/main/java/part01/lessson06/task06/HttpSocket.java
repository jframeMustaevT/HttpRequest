package part01.lessson06.task06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSocket {
    public static void main(String[] args) {
        HttpSocket httpSocket = new HttpSocket();
        httpSocket.start();
    }

    private void start() {
        ServerSocket serverSocket;

        System.out.println("HttpServer starting  port 8080");
        System.out.println("press  enter to exit");

        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.out.println("Error:" + e);
            return;
        }

        System.out.println("waiting for connection");
        for (; ; ) {
            try {
                Socket remote = serverSocket.accept();
                System.out.println("connection, sending ");

                BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
                PrintWriter out = new PrintWriter(remote.getOutputStream());

                //read the data sent
                String str = ".";
                while (!str.equals(""))
                    str = in.readLine();

                //Send the response
                out.println("HTTP/1.1");
                out.println("ContentType: text/html");
                out.println("Server: Bot");
                out.println();
                out.println("<H1>SimpleHttpSocket- Innopolis</H1>");
                out.flush();
            } catch (Exception ex) {
                System.out.println("Error 404 not found" + ex.getMessage());
            }
        }


    }

}