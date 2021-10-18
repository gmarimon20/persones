package jaumebalmes.personesxml;

public class Main {
    
    public static void main(String[] args) {
        
        Persona llista[] = new Persona(4);
        
        llista[0] = new Persona("Pedro", "Martínez", 26, 664485132);
        llista[1] = new Persona("Miguel", "Navarro", 43, 651874523);
        llista[2] = new Persona("Jordina", "Pujol", 35, 648153244);
        llista[3] = new Persona("Gerard", "Piqué", 36, 618475551);
        
        Filtre temp[] = new Filtre(4);
        
        for (int i = 0; i < 4; i++) 
            temp[i] = new Filtre(llista[i]);
        
        
    }
    
}
