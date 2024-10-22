public class Cuadrado implements IFigura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double getPerimetro() {
        return lado * 4;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "Cuadrado [lado=" + lado + ", Perimetro=" + getPerimetro() + ", Area=" + getArea()
                + ", Tipo=" + getClass() + "]";
    }
}
