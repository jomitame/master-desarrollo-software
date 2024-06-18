import java.util.StringTokenizer;

class Fecha {

    private int day;
    private int month;
    private int year;
    private static final int[] DAYS_OF_MONTHS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // DAYS_LETTERS starts with 's' because 1/1/1 was saturday (wikipedia)
    private static final char[] DAYS_LETTERS  = new char[]{'s', 'd', 'l', 'm', 'm', 'j', 'v'};

    public Fecha(){
        this(1,1,1);
    }

    public Fecha(int day, int month, int year){
        this.set(day, month, year);
    }

    public Fecha(Fecha fecha){
        this(fecha.day, fecha.month, fecha.year);
    }

    public Fecha(String stringFecha) {
        StringTokenizer stringTokenizer = new StringTokenizer(stringFecha, "/");
        this.day = Integer.parseInt(stringTokenizer.nextToken());
        this.month = Integer.parseInt(stringTokenizer.nextToken());
        this.year = Integer.parseInt(stringTokenizer.nextToken());
    }

    public Fecha cloneMe() {
        return new Fecha(this.day, this.month, this.year);
    }

    public boolean equal(Fecha fecha) {
        return this.day == fecha.getDay() && this.month == fecha.getMonth() && this.year == fecha.getYear();
    }

    public void show() {
        new GestorIO().out(this.day + "/" + this.month + "/" + this.year);
    }

    public String toStringCAS() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public String toStringUSA() {
        return this.month + "/" + this.day + "th" + this.year;
    }

    private void set(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void set(Fecha fecha) {
        this.set(fecha.day, fecha.month, fecha.year);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public static boolean leap(int year) {
        return  year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int daysOfYear(int year){
        int days = 365;
        if (Fecha.leap(year)) {
            days++;
        }
        return days;
    }

    public int dayOfYear() {
        int result = this.getDay();
        for (int i=0; i<(this.getMonth() - 1); i++) {
            result += DAYS_OF_MONTHS[i];
        }
        if (this.getMonth() > 2 && this.isLeap()) {
            result ++;
        }

        return result;
    }

    public boolean isLeap() {
        return Fecha.leap(this.year);
    }

    private int daysToOrigin() {
        int result = this.dayOfYear();

        result += 365 * (this.getYear() -1);

        for (int i=1; i < this.getYear() -1; i++) {
             if (Fecha.leap(i)) {
                 result ++;
             }
         }

        return result;
    }

    public boolean isBefore(Fecha fecha) {
        return this.daysToOrigin() < fecha.daysToOrigin();
    }

    public boolean isAfter(Fecha fecha) {
        return this.daysToOrigin() > fecha.daysToOrigin();
    }

    public int difference(Fecha fecha) {
        return this.daysToOrigin() - fecha.daysToOrigin();
    }

    public char weekDay() {
        return DAYS_LETTERS[(this.daysToOrigin() % 7) - 1];
    }

    public boolean isWeekEnd() {
        final char WEEK_DAY = this.weekDay();
        return WEEK_DAY == 's' || WEEK_DAY == 'd';
    }

    public int weekNumber() {
        return (this.daysToOrigin() - new Fecha(1,1, this.getYear()).daysToOrigin()) / 7 + 1;
    }

    private void increment() {
        this.day ++;
        if (this.getDay() > DAYS_OF_MONTHS[this.getMonth() - 1]) {
            this.day = 1;
            this.month ++;
            if (this.getMonth() > 12) {
                this.month = 1;
                this.year ++;
            }
        }
    }

    public void increment(int days) {
        for (int i=0; i < days; i++){
            this.increment();
        }
    }

    public static void main(String[] args) {
        boolean yesItIs = Fecha.leap(2100);
        System.out.println(yesItIs);
    }
}