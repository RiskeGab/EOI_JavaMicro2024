public class Circulo implements IFigura {
    private double radio;   

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double getPerimetro() {
        return Math.PI * radio * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }

    public double getRadio() {
        return radio;
    }
}
