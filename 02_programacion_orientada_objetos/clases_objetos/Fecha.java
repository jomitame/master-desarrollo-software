class Fecha {
    public Fecha(){}

    public Fecha(int day, int month, int year){}

    public Fecha(Fecha fecha){}

    public Fecha(int timeStamp) {}

    public Fecha(String stringFecha) {}

    public Fecha clone() {
        return null;
    }

    public char weekDay() {
        return ' ';
    }

    public boolean equal(Fecha fecha) {
        return false;
    }

    public boolean holiday() {
        return false;
    }

    public int difference(Fecha fecha) {
        return 0;
    }

    public void show() {}

    public String toStringCAS() {
        return null;
    }

    public String toStringUSA() {
        return null;
    }

    public String toString(int format) {
        return null;
    }

    public void set(Fecha fecha) {}

    public int getDay() {
        return 0;
    }

    public int getMonth() {
        return 0;
    }

    public int getYear() {
        return 0;
    }

    public char station() {
        return ' ';
    }

    public int weekNumber() {
        return 0;
    }

    public void increment(int days) {}

    public boolean checkIsBisest() {
        return false;
    }

    public Fecha currentDate() {
        return  null;
    }

    public static void main(String[] args) {

    }
}