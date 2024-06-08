/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalveterinariog7;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Estudiante 2
 */
public class Paciente {
    private String identificacion;
    private String nombre;
    private String claseAnimal;
    private String raza;
    private String sexo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private String idClientePropietario;
    private String numeroPoliza;

    public Paciente(String identificacion, String nombre, String claseAnimal, String raza, String sexo, LocalDate fechaNacimiento, LocalDate fechaIngreso, String idClientePropietario, String numeroPoliza) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.claseAnimal = claseAnimal;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.idClientePropietario = idClientePropietario;
        this.numeroPoliza = numeroPoliza;
    }

    public Paciente(String string, String string2, String string3, int i, boolean b) {
        //TODO Auto-generated constructor stub
    }

    public long calcularDiasHospitalizado() {
        return ChronoUnit.DAYS.between(fechaIngreso, LocalDate.now());
    }

    // Getters y setters

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaseAnimal() {
        return claseAnimal;
    }

    public void setClaseAnimal(String claseAnimal) {
        this.claseAnimal = claseAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIdClientePropietario() {
        return idClientePropietario;
    }

    public void setIdClientePropietario(String idClientePropietario) {
        this.idClientePropietario = idClientePropietario;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }
}
