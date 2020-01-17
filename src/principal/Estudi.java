/*
 * Classe que defineix un estudi. Un estudi es defineix per un codi, un nom i adreça 
 * on està ubicat. A més, contindrà vectors amb dissenyadors, jardiners, torns 
 * i projectes.
 */
package principal;

import components.Component;
import components.Dissenyador;
import components.Jardiner;
import components.Torn;
import components.Treballador;

public class Estudi implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private String adreca;
    private Component[] components = new Component[160];
    private int posicioComponents = 0;

    public Estudi(String nom, String adreca) {
        this.codi = properCodi;
        properCodi++;
        this.nom = nom;
        this.adreca = adreca;
    }


    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }

     public static Estudi addEstudi() {

        String nom;
        String adreca;

        System.out.println("Nom de l'estudi:");
        nom = DADES.nextLine();
        System.out.println("Adreça de l'estudi:");
        adreca = DADES.nextLine();
        return new Estudi(nom, adreca);
    }
     
@Override
    public void updateComponent() {

        System.out.println("\nNom de l'estudi: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nAdreça de l'estudi: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.next();
    }
@Override
    public void showComponent() {
        System.out.println("\nLes dades de l'estudi amb codi " + codi + " són: ");
        System.out.println("\nNom: " + nom);
        System.out.println("\nAdreça: " + adreca);
    }

    public void addDissenyador() {

        Dissenyador nouDissenyador = Dissenyador.addDissenyador();

        if (selectComponent(1,nouDissenyador.getNif()) == -1) {
            this.components[posicioComponents] = nouDissenyador;
            this.posicioComponents++;
        } else {
            System.out.println("\nEl dissenyador o dissenyadora ja existeix");
        }
    }    
    
        public void addJardiner() {

        Jardiner nouJardiner = Jardiner.addJardiner();

        if (selectComponent(2,nouJardiner.getNif()) == -1) {
            this.components[posicioComponents] = nouJardiner;
            this.posicioComponents++;
        } else {
            System.out.println("\nEl jardiner o jardinera ja existeix");
        }
    }
   
    public void addTorn() {

        Torn nouTorn = Torn.addTorn();

        if (selectComponent(3, nouTorn.getCodi()) == -1) {
            this.components[posicioComponents] = nouTorn;
            this.posicioComponents++;
        } else {
            System.out.println("\nEl torn ja existeix");
        }
    }

    public void addProjecte() {

        Projecte nouProjecte = Projecte.addProjecte();

        if (selectComponent(4,nouProjecte.getCodi()) == -1) {
            this.components[posicioComponents] = nouProjecte;
            this.posicioComponents++;
        } else {
            System.out.println("\nEl projecte ja existeix");
        }
    }
  
   
    public int selectComponent(int tipus, Object id) {        

        if (id == null) {
            switch (tipus) {
                case 1:
                    System.out.println("Introduce NIF del dissenyador/a?: ");
                    break;
                case 2:
                    System.out.println("Introduce NIF del jardiner/a?: ");
                    break;
                case 3:
                    System.out.println("Introduce codi del torn?:");
                    break;
                case 4:
                    System.out.println("Introduce codi del projecte?: ");
                    break;
            }
            id = DADES.next();
        }
        
        int posElement = -1; 
            for (int i = 0; i < posicioComponents; i++) {
                if (components[i] instanceof Dissenyador && tipus == 1) {
                    if (((Dissenyador) components[i]).getNif().equals(id)) {
                        return i;
                    }
                } else if (components[i] instanceof Jardiner && tipus == 2) {
                    if (((Jardiner) components[i]).getNif().equals(id)) {
                        return i;
                    }
                } else if (components[i] instanceof Torn && tipus == 3) {
                    if (((Torn) components[i]).getCodi().equals(id)) {
                        return i;
                    }
                } else if (components[i] instanceof Projecte && tipus == 4) {
                    if (((Projecte) components[i]).getCodi() == Integer.parseInt((String) id)) {
                        return i;
                    }
                }
            }

        return posElement;        
    }
    
    

    public void addTornJardiner() {
        
        Jardiner jardinerSel = null;
        int pos = selectComponent(2,null);

        if (pos >= 0) {

            jardinerSel = (Jardiner)this.getComponents()[pos];

            pos = selectComponent(3, null);

            if (pos >= 0) {
                jardinerSel.setTorn((Torn) getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest torn");
            }

        } else {
            System.out.println("\nNo existeix aquest jardiner o jardinera");
        }

    }
  

    public void addTreballadorProjecte(int tipus) {
        boolean trobat = false;
        Projecte projecteSel = null;
        int pos = selectComponent(4, null);

        if (pos >= 0) {

            projecteSel = (Projecte) this.getComponents()[pos];

            pos = selectComponent(tipus, null);

            if (pos >= 0) {
                 if (tipus == 1) {
                    
                    for (int i = 0; i < projecteSel.getPosicioTreballadors() && !trobat; i++) {
                        if (projecteSel.getTreballadors()[i] instanceof Dissenyador) {
                            System.out.println("\nEl projecte ja té assignat un dissenyador o dissenyadora");
                            trobat = true;
                        }
                    }
                    
                } else { //jardiner

                    for (int i = 0; i < projecteSel.getPosicioTreballadors() && !trobat; i++) {
                        if (((Treballador) getComponents()[pos]).equals(projecteSel.getTreballadors()[i])) {
                            System.out.println("\nAquest jardiner ja està assignat al projecte");
                            trobat = true;
                        }
                    }
                }

                if (!trobat) {
                    projecteSel.addTreballador((Treballador)getComponents()[pos]);
                }
            } else {
                System.out.println("\nNo existeix aquest treballador o treballadora");
            }

        } else {
            System.out.println("\nNo existeix aquest projecte");
        }
    }


}


// ((Dissenyador) components [i]).getNif().equal
//Obj id ==
//pedir identificador de cada tipo. Si eres diss dame el nif, turno -- codigo, jardinero -- nif, 
//Tipo y luego los constuctores