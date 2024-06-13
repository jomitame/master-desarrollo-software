public class Intervalo {

    private double middlePoint;
    private double length;

    private double getMinimun() {
        return this.middlePoint - this.length/2;
    }

    private double setMinimun(double minimun) {
        this.length = this.getMaximun(); - minimun;
        this.middlePoint = minimun + this.length/2;
    }

    private double getMaximun() {
        return this.middlePoint + this.length/2;
    }

    private double setMaximun(double maximun) {
        this.length = maximun - this.getMinimun();
        this.middlePoint = maximun - this.length/2;
    }

    public double getLength() {
        return this.getMaximun() - this.getMinimun();
    }

    public Intervalo(double min, double max) {
        this.setMinimun(min);
        this.setMaximun(max);
    }

    public Intervalo(double max) {
        this(0, max);
    }

    public Intervalo(Intervalo interval) {
        this.(interval.getMinimun(), interval.getMaximun());
    }

    public Intervalo() {
        this(0,0);
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    public void defer(double displacement) {
        this.setMinimun(this.getMinimun() + displacement);
        this.setMaximun(this.getMaximun() + displacement);
    }

    public Intervalo displaced(double displacement) {
        Intervalo intervalo = this.clone();
        intervalo.defer(displacement);
        return intervalo;
    }

    public boolean include(double value) {
        return this.getMinimun() <= value && value <= this.getMaximun();
    }

    public boolean include(Intervalo interval) {
        assert interval != null;
        return this.include(interval.getMinimun()) && this.include(interval.getMaximun());
    }

    public boolean equals(Intervalo interval) {
        assert interval != null;
        return this.getMinimun() == interval.getMinimun() && this.getMaximun() == interval.getMaximun();
    }

    public Intervalo intersection(Intervalo interval) {
        assert this.intersects(interval);
        if (this.include(interval)) {
            return interval.clone();
        } else if (interval.include(this)) {
            return this.clone();
        } else if (this.include(interval.getMinimun())) {
            return new Intervalo(interval.getMinimun(), this.getMaximun());
        } else {
            return new Intervalo(this.getMinimun(), interval.getMaximun());
        }
    }

    public boolean intersects(Intervalo interval) {
        assert interval != null;
        return this.include(interval.getMinimun()) || this.include(interval.getMaximun()) || interval.include(this);
    }

    public void oppose() {
        double initMin = this.getMinimun();
        double initMax = this.getMaximun();
        this.setMinimun(-initMax);
        this.setMaximun(-initMin);
    }

    public void duplicate() {
        double initLength = this.getLength();
        this.setMinimun(getMinimun() - initLength/2);
        this.setMaximun(getMaximun() + initLength/2);
    }

    public void pick() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Minimun?");
        this.setMinimun(gestorIO.inDouble());
        gestorIO.out("Maximun?");
        this.setMaximun(gestorIO.inDouble());

    }

    public void show() {
        new GestorIO.out("[" + this.getMinimun() + "," + getMaximun() + "]")
    }

    public Intervalo[] cutUp(int pieces) {
        return null;
    }

}

