package foro;

import javax.swing.JOptionPane;

public class Usuario extends Observador {
    private ReviewDeProductos redSocial;
    private Object apuntes;

    public void setBlog(ReviewDeProductos redSocial) {
        this.redSocial = redSocial;
    }

    public void actualizar() {
        if(redSocial.getEstado().equals("activo")){
            JOptionPane.showMessageDialog(null,"usuario notificado");
        }
    }

    public Usuario(ReviewDeProductos redSocial) {
        this.redSocial = redSocial;
        redSocial.registrar(this);
    }
}