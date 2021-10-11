
package jaumebalmes.personesxml;

public class Filtre {
    String name;
    int age;
    
    Filtre(){
    }
    
    Filtre(Persona p){
        this.name = p.getName();
        this.age = p.getAge();
    }

    //<editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
//</editor-fold>
    
    
}
