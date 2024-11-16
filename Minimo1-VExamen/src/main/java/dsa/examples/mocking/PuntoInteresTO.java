package dsa.examples.mocking;

public class PuntoInteresTO {
    public int coordenadaX;
    public int coordenadaY;
    public ElementType tipo;

    public PuntoInteresTO(int coordenadaX, int coordenadaY, ElementType tipo) {

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
