/*
 * Classe que defineix un torn. Un torn es defineix pel seu codi, nom, hora d'inici
 * i hora de finalització del torn.
 */

package components;

public class Torn implements Component {

    private String codi;
    private String nom;
    private String horaInici;
    private String horaAcabament;

    public Torn(String codi, String nom, String horaInici, String horaAcabament) {
        this.codi = codi;
        this.nom = nom;
        this.horaInici = horaInici;
        this.horaAcabament = horaAcabament;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(String horaInici) {
        this.horaInici = horaInici;
    }

    public String getHoraAcabament() {
        return horaAcabament;
    }

    public void setHoraAcabament(String horaAcabament) {
        this.horaAcabament = horaAcabament;
    }

    public static Torn addTorn() {
        String codi;
        String nom;
        String horaInici;
        String horaAcabament;

        System.out.println("Codi del torn:");
        codi = DADES.next();
        System.out.println("Nom del torn:");
        nom = DADES.next();
        System.out.println("Hora d'inici del torn:");
        horaInici = horesTorn();
        System.out.println("Hora de finalització del torn:");
        horaAcabament = horesTorn();

        return new Torn(codi, nom, horaInici, horaAcabament);
    }

    @Override
    public void updateComponent() {
        System.out.println("\nCodi del torn: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        System.out.println("\nNom del torn: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.next();
        System.out.println("Hora d'inici del torn: "+horaInici);
        System.out.println("\nEntra la nova hora d'inci del torn:");
        horaInici = horesTorn();
        System.out.println("Hora d'acabament del torn: "+horaAcabament);
        System.out.println("\nEntra la nova hora d'acabament del torn:");
        horaAcabament = horesTorn();        
    }

    @Override
    public void showComponent() {
        System.out.println("\nLes dades del torn amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHora d'inici: "+horaInici);
        System.out.println("\nHora de finalització: "+horaAcabament);
    }     

    public static String horesTorn() {
        int hora;
        int minuts;
        String stHora;
        String stMinuts;

        do {
            System.out.println("Hora:");
            hora = DADES.nextInt();
        } while (hora < 0 || hora > 23);

        do {
            System.out.println("Minuts:");
            minuts = DADES.nextInt();
        } while (hora < 0 || hora > 23);

        if (hora >= 0 && hora <= 9) {
            stHora = "0"+hora;
        } else {
            stHora = String.valueOf(hora);
        }

        if (minuts >= 0 && minuts <= 9) {
            stMinuts = "0"+minuts;
        } else {
            stMinuts = String.valueOf(minuts);
        }

        return stHora + ":" + stMinuts;
    }
    
}
