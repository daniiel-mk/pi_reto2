package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Fichero {

    private static final String NOMBRE_ARCHIVO = "videojuegos.txt";

    //Metodo para guardar los videojuegos
    public static void guardarVideojuegos(List<Videojuego> videojuegos) {

        StringBuilder contenido = new StringBuilder();

        for (Videojuego videojuego : videojuegos) {

            contenido.append("Título: ").append(videojuego.getTitulo()).append("\n");
            contenido.append("Fecha de lanzamiento: ").append(videojuego.getFechaLanzamiento()).append("\n");
            contenido.append("Precio: ").append(videojuego.getPrecio()).append("\n");
            contenido.append("Valoración: ").append(videojuego.getValoracion()).append("\n");
            contenido.append("Porcentaje positivo: ").append(videojuego.getPorcentajePositivo()).append("\n");
            contenido.append("----------------------------------------\n");
        }

        try {
            Files.writeString(
                    Path.of(NOMBRE_ARCHIVO),
                    contenido.toString(),
                    StandardCharsets.UTF_8
            );

            System.out.println("Videojuegos guardados correctamente en " + NOMBRE_ARCHIVO);

        } catch (IOException e) {
            System.out.println("Error al guardar los videojuegos.");
            e.printStackTrace();
        }
    }

    //Metodo para leer el archivo
    public static void leerVideojuegos() {

        try {
            String contenido = Files.readString(
                    Path.of(NOMBRE_ARCHIVO),
                    StandardCharsets.UTF_8
            );

            System.out.println("\n========== VIDEOJUEGOS GUARDADOS ==========");
            System.out.println(contenido);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}