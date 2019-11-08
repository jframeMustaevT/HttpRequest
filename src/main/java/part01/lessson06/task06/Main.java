package part01.lessson06.task06;

import java.io.*;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
 //host and port
        String host="10.10.90.89";
        int port=8080;

        //Create TCP socket

        Socket socket =new Socket(host,port);

        //Create IO streams and connect the network socket

        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true); // TODO: 07.11.2019 add true for clear buffer input

        //Send request HTTP server
        out.println("GET/index/html HTTP/1.1");
        out.println();
        out.flush();

        //Read response and display to the console
       String  line;//

        //ReadLine returns readLine null if close network socket
        while ((line=in.readLine()) !=null){
            System.out.println(line);  //
        }

        in.close();
        out.close();

    }
}
