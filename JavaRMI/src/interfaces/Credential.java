/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Credential implements Serializable{
    public String name;
    public String ciudad;
    public int año;
    public String telefono;

    public Credential(String name, String ciudad, int año, String telefono) {
        this.name = name;
        this.ciudad = ciudad;
        this.año = año;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
