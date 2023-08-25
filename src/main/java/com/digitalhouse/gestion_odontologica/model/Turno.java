package com.digitalhouse.gestion_odontologica.model;
import java.util.Date;

public class Turno {
    private int Id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date fecha;

    public Turno() {

    }

    @Override
    public String toString() {
        return "Turno{" +
                "Id=" + Id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }

    public Turno(int id, Paciente paciente, Odontologo odontologo, Date fecha) {
        Id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
    }

