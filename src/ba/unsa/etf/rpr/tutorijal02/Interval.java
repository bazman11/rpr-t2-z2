package ba.unsa.etf.rpr.tutorijal02;

import java.lang.IllegalArgumentException;

public class Interval {
    double pocetna, krajnja;
    boolean pocetnaPripada, krajnjaPripada;

    public Interval(double pocetna, double krajnja, boolean pocetnaPripada, boolean krajnjaPripada) throws IllegalArgumentException {
        if(pocetna > krajnja) throw new IllegalArgumentException("Pocetna tacka ne moze biti veca od krajnje!!");
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }

    public Interval() {
        this.pocetna = 0;
        this.krajnja = 0;
        this.pocetnaPripada = false;
        this.krajnjaPripada = false;
    }

    @Override
    public String toString() {
        if(this.pocetna == 0 && this.krajnja ==0 && !this.pocetnaPripada) return ("()");
        if(this.pocetnaPripada && this.krajnjaPripada) return ("[" + this.pocetna + "," + this.krajnja + "]");
        if(this.pocetnaPripada) return ("[" + this.pocetna + "," + this.krajnja + ")");
        if(this.krajnjaPripada) return ("(" + this.pocetna + "," + this.krajnja + "]");
        return ("(" + this.pocetna + "," + this.krajnja + ")");
    }
    public boolean isNull(){
        return this.pocetna == 0 && this.krajnja == 0 && !this.pocetnaPripada && !this.krajnjaPripada;
    }

    public boolean isIn(double tacka){
        if((tacka > this.pocetna && tacka < this.krajnja) || (tacka == this.pocetna && this.pocetnaPripada)) return true;
        return tacka == this.krajnja && this.krajnjaPripada;
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

}