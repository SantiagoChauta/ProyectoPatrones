package foro;

public class ReviewDeProductos extends Foro {
    private Object tema;

    /*public ReviewDeProductos() {
        ReviewDeProductos sub = new ReviewDeProductos();
        sub.setTema(new Object());
        Usuario obs = new Usuario();
        obs.setBlog(sub);
        sub.notificar();
    }*/

    public Object getTema() {
        return tema;
    }

    public void setTema(Object tema) {
        tema = tema;
    }
}