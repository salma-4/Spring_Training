public class Square implements Shape {
    private int l;
    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }



    @Override
    public double calcArea(int l){
        return l*l;
    }
}
