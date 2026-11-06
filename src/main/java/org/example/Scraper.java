package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

    public static List<Videojuego> obtenerVideojuegos() throws IOException {

        String url = "https://store.steampowered.com/search/?term=&l=spanish&cc=es";

        List<Videojuego> videojuegos = new ArrayList<>();

        Document documento = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(20000)
                .get();

        Elements juegos = documento.select("a.search_result_row");

        System.out.println("Videojuegos encontrados: " + juegos.size());

        for (Element juego : juegos) {

            String titulo = juego.select(".title").text();

            String fechaLanzamiento = juego.select(".search_released").text();

            String precio = juego.select(".discount_final_price").text();

            Element elementoValoracion = juego.selectFirst(".search_review_summary");

            String valoracion = "Sin valoraciones";
            String porcentajePositivo = "No disponible";

            if (elementoValoracion != null) {

                valoracion = elementoValoracion.attr("data-tooltip-html");

                if (valoracion.contains("%")) {
                    porcentajePositivo = valoracion.substring(
                            valoracion.indexOf("El ") + 3,
                            valoracion.indexOf("%") + 1
                    );
                }

                if (valoracion.contains("<br")) {
                    valoracion = valoracion.substring(0, valoracion.indexOf("<br"));
                }
            }

            if (precio.isEmpty()) {
                precio = "No disponible";
            }

            Videojuego nuevoVideojuego = new Videojuego(
                    titulo,
                    fechaLanzamiento,
                    precio,
                    valoracion,
                    porcentajePositivo
            );

            videojuegos.add(nuevoVideojuego);
        }

        return videojuegos;
    }
}