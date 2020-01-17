/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;

public class Jardiner extends Treballador implements Component {
  
    private Torn torn;

    public Jardiner(String nif, String nom) {
        super(nif,nom);
        this.torn = null;
    }
    
    public Torn getTorn() {
        return this.torn;
    }

    public void setTorn(Torn torn) {
        this.torn = torn;
    }
    
    public static Jardiner addJardiner() {
        String nif;
        String nom;
        Torn torn;

        System.out.println("NIF del jardiner o jardinera:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("Nom del jardiner o jardinera:");
        nom = DADES.nextLine();        

        return new Jardiner(nif, nom);
    }
    
    @Override
    public void updateComponent() {
        super.updateComponent();
    }
    
    @Override
    public void showComponent(){
        super.showComponent();
        this.torn.showComponent();
    }

}
