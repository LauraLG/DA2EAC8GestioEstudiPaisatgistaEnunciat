/*
 * Classe que defineix un dissenyador/a. Un dissenyador/a
 * es defineix pel seu nif, nom i estat, és a dir, actiu si està treballant o no 
 * actiu si està de baixa o vacances.
 */
package components;

public class Dissenyador extends Treballador implements Component {

    public Dissenyador(String nif, String nom) {
        super(nif,nom);
    }

    public static Dissenyador addDissenyador() {
        String nif, nom;
        
        System.out.println("Introduce los datos del nuevo diseñador");        
        System.out.println("El nombre del diseñador/a: ");
        
        nom = DADES.nextLine();
     
        System.out.println("Introduce el NIF del diseñador/a");
        nif = DADES.nextLine();   
        
        return new Dissenyador(nif, nom);  
    }
    
    @Override
    public void updateComponent() {
        super.updateComponent();
    }    
    
    @Override
    public void showComponent() {
        super.updateComponent();
    }
}
