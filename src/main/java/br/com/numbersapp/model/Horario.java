package br.com.numbersapp.model;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Horario {
    private ZonedDateTime dat;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

    public Horario (String dat) {
        this.setDat(dat);
    }

    public Horario() {
        this.dat = null;
    }

    public void setDat(String dat) {
        try {
            this.dat = ZonedDateTime.parse(dat, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use: dd-MM-yyyy HH:mm");
        }
    }

    public LocalDate getDat() {
        return this.dat.format(formatter)
    }

    public void setHora(String hora) {this.hora = LocalTime.parse(hora, simpleDateFormat2);}

    public LocalTime getHora() {
        return this.hora;
    }

    public void printHorario(){
        System.out.println("Data: " + simpleDateFormat.format(String.valueOf(this.dat)));
        System.out.println("Hora: " + simpleDateFormat.format(String.valueOf(this.hora)));
    }
}
