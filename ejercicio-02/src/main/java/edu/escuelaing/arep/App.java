package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        URL url;
        System.out.println("Digite url");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            url = new URL(reader.readLine().trim());
            File resultado = new File("resultado.html");
            if (resultado.exists()) {
                resultado.delete();
            }
            BufferedReader readURL = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            FileWriter fw = new FileWriter("resultado.html");
            BufferedWriter bw = new BufferedWriter(fw);
            while ((inputLine = readURL.readLine()) != null) {
                bw.write(inputLine);
                bw.write("\n");
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
