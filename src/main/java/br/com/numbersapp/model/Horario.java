package br.com.numbersapp.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
    private LocalDate dat;
    private LocalTime hora;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");

    public Horario (String dat, String hora) {
        this.dat = LocalDate.parse(dat);
        this.hora = LocalTime.parse(hora);
    }

    public Horario() {
        this.dat = null;
        this.hora = null;
    }

    public void setDat(String dat) {
        this.dat = LocalDate.parse(dat);
    }

    public LocalDate getDat() {
        return this.dat;
    }

    public void setHora(String hora) {
        this.hora = LocalTime.parse(hora);
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void printHorario(){
        System.out.println("Data: " + simpleDateFormat.format(String.valueOf(this.dat)));
        System.out.println("Hora: " + simpleDateFormat.format(String.valueOf(this.hora)));
    }
}
