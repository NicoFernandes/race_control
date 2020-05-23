package Clases;

import java.io.Serializable;

public class Coche implements Serializable, Comparable<Coche> {
    private int numero_coche;
    private String marca;
    private String modelo;
    private Garaje garaje;
    private int puntos;

    public Coche(int numero_coche, String marca, String modelo, Garaje garaje) {
        this.numero_coche = numero_coche;
        this.marca = marca;
        this.modelo = modelo;
        this.garaje = garaje;
    }

    public Coche() {
    
    }

    public int getNumero_coche() {
        return numero_coche;
    }

    public void setNumero_coche(int numero_coche) {
        this.numero_coche = numero_coche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
     @Override
        public int compareTo(Coche c) {
            if (puntos < c.getPuntos()) {
                return 1;
            }
            if (puntos >c.getPuntos()) {
                return -1;
            }
            return 0;
        }
    
    
    
}
