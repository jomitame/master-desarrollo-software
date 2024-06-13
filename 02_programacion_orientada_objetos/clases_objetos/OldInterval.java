class OldInterval {
    private double min;
    private double max;

    public OldInterval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public OldInterval(double max) {
        this(0.0, max);
    }

    public OldInterval(OldInterval oldInterval) {
        this(oldInterval.min, oldInterval.max);
    }

    public OldInterval() {
        this(0.0, 0.0);
    }

    public OldInterval cloneMe() {
        return new OldInterval(this);
    }

    public double getLength() {
        return max - min;
    }

    public void defer(double displacement) {
        this.min += displacement;
        this.max += displacement;
    }

    public OldInterval displaced(double displacement) {
        OldInterval oldInterval = this.cloneMe();
        oldInterval.defer(displacement);
        return oldInterval;
    }

    public boolean include(double value) {
        return this.min <= value && value <= this.max;
    }

    public boolean include(OldInterval oldInterval) {
        assert oldInterval != null;
        return this.include(oldInterval.min) && this.include(oldInterval.max);
    }

    public boolean equals(OldInterval oldInterval) {
        assert oldInterval != null;
        return this.min == oldInterval.min && this.max == oldInterval.max;
    }

    public boolean intersects(OldInterval oldInterval) {
        assert oldInterval != null;
        return this.include(oldInterval.min) || this.include(oldInterval.max) || oldInterval.include(this);
    }

    public OldInterval intersection(OldInterval oldInterval) {
        assert this.intersects(oldInterval);
        if (this.include(oldInterval)) {
            return oldInterval.cloneMe();
        } else if (oldInterval.include(this)) {
            return this.cloneMe();
        } else if (this.include(oldInterval.min)) {
            return new OldInterval(oldInterval.min, this.max);
        } else {
            return new OldInterval(this.min, oldInterval.max);
        }
    }

    public void oppose() {
        double initialMin = this.min;
        double initialMax = this.max;
        this.min = -initialMax;
        this.max = -initialMin;
    }

    public void duplicate() {
        double initialLength = this.getLength();
        this.min -= initialLength/2;
        this.max += initialLength/2;
    }

    public void pick() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Minimun?");
        this.min = gestorIO.inDouble();
        gestorIO.out("Maximun?");
        this.max = gestorIO.inDouble();
    }

    public void show() {
        new GestorIO().out("[" + this.min + "," + this.max + "]");
    }

    public OldInterval[] cutUp(int pieces) {
        return null;
    }

    public static void main(String[] args) {
        OldInterval oldInterval = new OldInterval();
        oldInterval.pick();
        oldInterval.show();
        new GestorIO().out("Length: "+oldInterval.getLength());
    }
}