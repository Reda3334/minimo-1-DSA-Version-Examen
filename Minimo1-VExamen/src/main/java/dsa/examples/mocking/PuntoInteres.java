package dsa.examples.mocking;

public class PuntoInteres {
    public int coordenadaX;
    public int coordenadaY;
    public ElementType tipo;

    public PuntoInteres(int coordenadaX, int coordenadaY, ElementType tipo) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tipo = tipo;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public ElementType getTipo() {
        return tipo;
    }

    public void setTipo(ElementType tipo) {
        this.tipo = tipo;
    }

}