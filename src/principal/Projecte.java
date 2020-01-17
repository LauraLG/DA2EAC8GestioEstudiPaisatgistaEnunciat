/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Component;
import components.Dissenyador;
import components.Jardiner;
import components.Treballador;

public class Projecte implements Component{
    
    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Treballador[] treballadors = new Treballador[41];
    private int posicioTreballadors = 0;//Primera posició buida del vector jardiners
    
    public Projecte(String nifClient, double pressupost) {
        codi = properCodi;
        properCodi++;
        this.nifClient = nifClient;
        this.finalitzat = false;
        this.pressupost = pressupost;
        // eleiminar o no? this.treballador = null;
    }
    
    public int getCodi() {
        return this.codi;
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

    public String getNifClient() {
        return this.nifClient;
    }

    public void setNifClient(String nifClient) {
        this.nifClient = nifClient;
    }

    public boolean isFinalitzat() {
        return this.finalitzat;
    }

    public void setFinalitzat(boolean finalitzat) {
        this.finalitzat = finalitzat;
    }

    public double getPressupost() {
        return pressupost;
    }

    public void setPressupost(double pressupost) {
        this.pressupost = pressupost;
    }

    public Treballador[] getTreballador() {
        return treballadors;
    }

    public void setTreballador(Treballador[] treballador) {
        this.treballadors = treballador;
    }

    public Treballador[] getTreballadors() {
        return this.treballadors;
    }

    public void setTreballadors(Treballador[] treballadors) {
        this.treballadors = treballadors;
    }

    public int getPosicioTreballadors() {
        return this.posicioTreballadors;
    }

    public void setPosicioTreballadors(int posicioTreballadors) {
        this.posicioTreballadors = posicioTreballadors;
    }

    public static Projecte addProjecte() {

        String nif;
        double pressupost;

        System.out.println("NIF del client:");
        nif = DADES.next();
        System.out.println("Presupost del projecte:");
        pressupost = DADES.nextDouble();

        return new Projecte(nif, pressupost);
    }
    
    @Override
    public void updateComponent() {

        System.out.println("\nNIF del client: " + nifClient);
        System.out.println("\nEntra el nou NIF:");
        nifClient = DADES.nextLine();
        System.out.println("\nPresupost del projecte: " + pressupost);
        System.out.println("\nEntra el nou pressupost:");
        pressupost = DADES.nextDouble();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }
        
        System.out.println("\nEl projecte està finalitzat? (1 si està finalitzat o 0 en cas contrari):");
        
        int estat=DADES.nextInt();
        
        if(estat==1){
            finalitzat=true;
        }else{
            finalitzat=false;
        }
    }

    public void addTreballador(Treballador treballador) {
        treballadors[posicioTreballadors] = treballador;
        posicioTreballadors++;
    }
    
    @Override
    public void showComponent() {
        System.out.println("\nLes dades del projecte amb codi " + codi + " són:");
        System.out.println("\nNIF client: " + nifClient);
        System.out.println("\nPressupost: " + pressupost);
       // treballadors.showComponent();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }

        for (int i = 0; i < posicioTreballadors; i++) {
            treballadors[i].showComponent();
        }
    }
    
}