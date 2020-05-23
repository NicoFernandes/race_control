
package Clases;

import java.io.Serializable;
import java.util.ArrayList;


public  class Carrera implements Serializable{
    private String nombre;
    private ArrayList<Coche> participantes;
    enum tipoCarrera{ESTANDAR, ELIMINACION}
    private tipoCarrera tipo;
    private Coche[] podio;

    
    
   

    public Carrera() {
    }

    
    public Carrera(String nombre, ArrayList<Coche> participantes, tipoCarrera tipo) {
        this.nombre = nombre;
        this.participantes = participantes;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Coche> participantes) {
        this.participantes = participantes;
    }

    public String getTipo() {
        if (tipo.equals(tipo.ELIMINACION)) {
            return "ELIMINACION";
        }else if (tipo.equals(tipo.ESTANDAR)) {
            return "ESTANDAR";
        }

            
        return null;
    }

    public void setTipo(tipoCarrera tipo) {
        this.tipo = tipo;
    }
    
    public void carreraEstandar(){
       this.tipo = tipo.ESTANDAR;
    }
    
    public void carreraEliminacion(){
       this.tipo = tipo.ELIMINACION;
    }
    
    public Coche[] getPodio() {
        return podio;
    }

    public void setPodio(Coche[] podio) {
        this.podio = podio;
        
    }
    
    
    
    
    
    
    
}
