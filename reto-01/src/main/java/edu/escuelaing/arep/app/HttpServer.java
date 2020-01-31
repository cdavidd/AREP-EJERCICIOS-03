package edu.escuelaing.arep.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        while(true){
            try { 
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
        
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                                clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine, archivo;
            archivo = "/";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recibí: " + inputLine);
                if (!in.ready()) {break; }
                if(inputLine.contains("GET")){
                    System.out.println(inputLine.indexOf("/")+" "+inputLine.indexOf(" ",inputLine.indexOf(" ")+1));
                    archivo= inputLine.substring(inputLine.indexOf("/")+1, inputLine.indexOf(" ",inputLine.indexOf(" ")+1));
                    break;
                }
            }

            outputLine = getFile(archivo);
            /*
            outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Mi propio mensaje</h1>\n"
                + "</body>\n"
                + "</html>\n" + inputLine;
            */
            out.println(outputLine);
            out.close(); 
            in.close(); 
            clientSocket.close(); 
            serverSocket.close();
        }
    }
    public static String getFile(String file){
        String path ="src/main/resources/";
        File archivo;
        if (file.endsWith("html")){
            path += "web/"+file;
        }else if(file.endsWith(".js")){
            path += "js/"+file;
        }else{
            path += "img/"+file;
        }
        archivo = new File(path);
        if(archivo.exists()){
            
        }
        return "";

    }
  }