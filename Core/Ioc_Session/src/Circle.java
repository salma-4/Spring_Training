public class Circle implements  Shape{
    private int rad;

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    @Override
    public double calcArea(int rad) {

        return Math.PI*rad*rad;
    }
}
