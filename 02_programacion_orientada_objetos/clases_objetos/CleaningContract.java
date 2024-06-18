public class CleaningContract {

    private String company;
    private int year;
    private Intervalo[] cleaning;

    private Intervalo baseCleaning = new Intervalo(8, 12);
    private final double STANDAR_HOUR_PRICE = 10;
    private final double EXTRA_HOUR_PRICE = 12;

    public CleaningContract(String company, int year) {
        this.cleaning = new Intervalo[Fecha.daysOfYear(year)];
        this.company = company;
        this.year = year;
        for(int i = 0; i < Fecha.daysOfYear(year); i++) {
            this.cleaning[i] = this.baseCleaning.clone();
        }
    }

    private Intervalo getCleaning(Fecha fecha) {
        return this.cleaning[fecha.dayOfYear() - 1];
    }

    private void setCleaning(Fecha fecha, Intervalo cleaning) {
        this.cleaning[fecha.dayOfYear() - 1] = cleaning;
    }

    public void cancelCleaning(Fecha fecha) {
        this.setCleaning(fecha, null);
    }

    public void duplicate(Fecha fecha) {
        this.getCleaning(fecha).duplicate();
    }

    public void displace(Fecha fecha, int displacementHours) {
        this.getCleaning(fecha).displaced(displacementHours);
    }

    public void show() {
        GestorIO gestor = new GestorIO();
        gestor.out("Company: " + this.company);
        Fecha fecha = new Fecha();
        for(int i = 0; i < Fecha.daysOfYear(year); i++) {
            if(this.getCleaning(fecha) != null) {
                fecha.show();
                this.getCleaning(fecha).show();
            }
            fecha.increment(1);
        }
    }

    public double cost() {
        double result = 0;
        Fecha fecha = new Fecha();
        for(int i = 0; i < Fecha.daysOfYear(year); i++) {
            if(this.getCleaning(fecha) != null) {
              double standarHours = this.getCleaning(fecha).intersection(baseCleaning).getLength();
              double extraHours = this.getCleaning(fecha).getLength() - standarHours;
              result += STANDAR_HOUR_PRICE * standarHours + EXTRA_HOUR_PRICE * extraHours;
            }
        }
        return result;
    }
}
