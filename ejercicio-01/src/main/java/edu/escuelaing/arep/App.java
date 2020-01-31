package edu.escuelaing.arep;

import java.net.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        URL url;
        try {
            url = new URL(
                    "https://github.com/search?q=user%3Acdavidd+julian&type=RegistryPackages");
            System.out.println("Protocol " + url.getProtocol());
            System.out.println("Authority " + url.getAuthority());
            System.out.println("Host " + url.getHost());
            System.out.println("Port " + url.getPort());
            System.out.println("Path " + url.getPath());
            System.out.println("Query " + url.getQuery());
            System.out.println("File " + url.getFile());
            System.out.println("Ref " + url.getRef());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error en el url");
        }

    }
}
