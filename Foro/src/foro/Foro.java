package foro;

import java.util.List;
import java.util.ArrayList;

public abstract class Foro {
    private List<Observador> usuarios;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificar();
        
    }
    
    public Foro() {
        this.usuarios = new ArrayList<Observador>();
        estado="inactivo";
    }

    public void registrar(Observador obs) {
        usuarios.add(obs);
    }

    public void borrar(Observador obs) {
        usuarios.remove(obs);
    }

    public void notificar() {
        //para todos los observadores
        for (Observador obs_i : usuarios) {
            obs_i.actualizar();
        }
    }
}