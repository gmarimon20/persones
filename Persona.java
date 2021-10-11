
package jaumebalmes.personesxml;

import java.io.Serializable;

public class Persona implements Serializable {
    
    private String name;
    private String surname;
    private int age;
    private int phone;
   
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    Persona(){
        
    }
    
    Persona(String name, String surname, int age, int phone){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GETTERS && SERTTERS">
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getPhone() {
        return phone;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
//</editor-fold>
    
    
}
