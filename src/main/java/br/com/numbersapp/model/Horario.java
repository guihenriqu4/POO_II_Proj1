package br.com.numbersapp.model;

public class Horario {
    private String dat;
    private String hora;

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getDat() {
        return this.dat;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        return this.hora;
    }

    public void printHorario(){
        System.out.println("Data: " + this.dat);
        System.out.println("Hora: " + this.hora);
    }
}
