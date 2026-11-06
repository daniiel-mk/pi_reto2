package org.example;

public class Videojuego {

    private String titulo;
    private String fechaLanzamiento;
    private String precio;
    private String valoracion;
    private String porcentajePositivo;

    public Videojuego(String titulo, String fechaLanzamiento, String precio,
                      String valoracion, String porcentajePositivo) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.valoracion = valoracion;
        this.porcentajePositivo = porcentajePositivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getPrecio() {
        return precio;
    }

    public String getValoracion() {
        return valoracion;
    }

    public String getPorcentajePositivo() {
        return porcentajePositivo;
    }
}