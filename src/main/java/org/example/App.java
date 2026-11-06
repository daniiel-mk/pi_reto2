package org.example;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) {

        try {
            //1. Obtenemos los videojuegos mediante el scraping
            List<Videojuego> videojuegos = Scraper.obtenerVideojuegos();

            //2. Guardamos los videojuegos en el archivo de texto
            Fichero.guardarVideojuegos(videojuegos);

            //3. Leemos el archivo y mostramos su contenido
            Fichero.leerVideojuegos();

        } catch (IOException e) {
            System.out.println("No se ha podido realizar el scraping.");
            e.printStackTrace();
        }
    }
}