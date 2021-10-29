package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {
    double pocetna, krajnja;
    boolean pocetnaPripada, krajnjaPripada;

    public Interval(double pocetna, double krajnja, boolean pocetnaPripada, boolean krajnjaPripada){
        if (pocetna>krajnja) throw new IllegalArgumentException("Pocetna vrijednost je veca od krajnje");
        this.pocetna=pocetna;
        this.krajnja=krajnja;
        this.pocetnaPripada=pocetnaPripada;
        this.krajnjaPripada=krajnjaPripada;
    }

    public Interval(){
        this.pocetna=0;
        this.krajnja=0;
        pocetnaPripada=false;
        krajnjaPripada=false;
    }

    boolean isNull(){
        return this.pocetna==0 && this.krajnja==0 && !this.pocetnaPripada && this.krajnjaPripada;
    }

    boolean isIn(double tacka){
        if (tacka>this.pocetna && tacka <this.krajnja) return true;
        if (tacka==this.pocetna && this.pocetnaPripada) return true;
        return tacka==this.krajnja && this.krajnjaPripada;
    }

    public Interval intersect(Interval i) {
        if ((i.pocetna > this.pocetna) && (i.krajnja < this.krajnja) && (i.pocetnaPripada && i.krajnjaPripada))
            return new Interval(i.pocetna, i.krajnja, true, true);
        if ((i.pocetna > this.pocetna) && (i.krajnja < this.krajnja) && (!i.pocetnaPripada && !i.krajnjaPripada))
            return new Interval(i.pocetna, i.krajnja, false, false);
        if (i.pocetna > this.pocetna && i.krajnja < this.krajnja && !i.pocetnaPripada && i.krajnjaPripada)
            return new Interval(i.pocetna, i.krajnja, false, true);
        if (i.pocetna > this.pocetna && i.krajnja < this.krajnja && i.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(i.pocetna, i.krajnja, true, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && i.pocetnaPripada && this.krajnjaPripada)
            return new Interval(i.pocetna, this.krajnja, true, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && !i.pocetnaPripada && !this.krajnjaPripada)
            return new Interval(i.pocetna, this.krajnja, false, false);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && !i.pocetnaPripada && this.krajnjaPripada)
            return new Interval(i.pocetna, this.krajnja, false, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && i.pocetnaPripada && !this.krajnjaPripada)
            return new Interval(i.pocetna, this.krajnja, true, false);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && this.pocetnaPripada && i.krajnjaPripada)
            return new Interval(this.pocetna, i.krajnja, true, true);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && !this.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(this.pocetna, i.krajnja, false, false);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && !this.pocetnaPripada && i.krajnjaPripada)
            return new Interval(this.pocetna, i.krajnja, false, true);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && this.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(this.pocetna, i.krajnja, true, false);
        return this;
    }

    public static Interval intersect(Interval j, Interval i) {
        if ((i.pocetna > j.pocetna) && (i.krajnja < j.krajnja) && (i.pocetnaPripada && i.krajnjaPripada))
            return new Interval(i.pocetna, i.krajnja, true, true);
        if ((i.pocetna > j.pocetna) && (i.krajnja < j.krajnja) && (!i.pocetnaPripada && !i.krajnjaPripada))
            return new Interval(i.pocetna, i.krajnja, false, false);
        if (i.pocetna > j.pocetna && i.krajnja < j.krajnja && !i.pocetnaPripada && i.krajnjaPripada)
            return new Interval(i.pocetna, i.krajnja, false, true);
        if (i.pocetna > j.pocetna && i.krajnja < j.krajnja && i.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(i.pocetna, i.krajnja, true, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && i.pocetnaPripada && j.krajnjaPripada)
            return new Interval(i.pocetna, j.krajnja, true, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && !i.pocetnaPripada && !j.krajnjaPripada)
            return new Interval(i.pocetna, j.krajnja, false, false);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && !i.pocetnaPripada && j.krajnjaPripada)
            return new Interval(i.pocetna, j.krajnja, false, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && i.pocetnaPripada && !j.krajnjaPripada)
            return new Interval(i.pocetna, j.krajnja, true, false);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && j.pocetnaPripada && i.krajnjaPripada)
            return new Interval(j.pocetna, i.krajnja, true, true);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && !j.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(j.pocetna, i.krajnja, false, false);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && !j.pocetnaPripada && i.krajnjaPripada)
            return new Interval(j.pocetna, i.krajnja, false, true);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && j.pocetnaPripada && !i.krajnjaPripada)
            return new Interval(j.pocetna, i.krajnja, true, false);
        return j;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "pocetna=" + pocetna +
                ", krajnja=" + krajnja +
                ", pocetnaPripada=" + pocetnaPripada +
                ", krajnjaPripada=" + krajnjaPripada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetna, pocetna) == 0 && Double.compare(interval.krajnja, krajnja) == 0 && pocetnaPripada == interval.pocetnaPripada && krajnjaPripada == interval.krajnjaPripada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocetna, krajnja, pocetnaPripada, krajnjaPripada);
    }
}
