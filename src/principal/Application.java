package principal;
import static components.Component.DADES;
import components.Dissenyador;
import components.Jardiner;
import components.Torn;


public class Application {

    static private Estudi[] estudis = new Estudi[4];
    static private int posicioEstudis = 0;
    static private Estudi estudiActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'estudis");
            System.out.println("\n2. Gestió de projectes");
            System.out.println("\n3. Gestió de dissenyadors o dissenyadores");
            System.out.println("\n4. Gestió de jardiners o jardineres");
            System.out.println("\n5. Gestió de torns");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuEstudis();
                    break;
                case 2:
                    if (estudiActual != null) {
                        menuProjectes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 3:
                    if (estudiActual != null) {                        
                        menuComponents(1);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 4:
                    if (estudiActual != null) {
                        menuComponents(2);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 5:
                    if (estudiActual != null) {
                        menuComponents(3);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuEstudis() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar estudi");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista d'estudis");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    estudis[posicioEstudis] = Estudi.addEstudi();
                    posicioEstudis++;
                    break;
                case 2:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudiActual = estudis[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 3:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudis[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioEstudis; i++) {
                        estudis[i].showComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuComponents(int tipus) {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista de dissenyadors i dissenyadores");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    if (tipus == 1){
                        estudiActual.addDissenyador();
                    }else if (tipus == 2){
                        estudiActual.addJardiner();
                    }else if (tipus == 3) {
                        estudiActual.addTorn();
                    }
                    break;
                case 2:
                    int indexSel = estudiActual.selectComponent(tipus, null);
                    if (indexSel >= 0){
                        estudiActual.getComponents()[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquest component");
                    }
                    break;
                 case 3:
                    if (tipus == 2) {
                        estudiActual.addTornJardiner();
                    } else {
                        for (int i = 0; i < estudiActual.getPosicioComponents(); i++) {
                            if (estudiActual.getComponents()[i] instanceof Dissenyador && tipus == 1) {
                                estudiActual.getComponents()[i].showComponent();
                            } else if (estudiActual.getComponents()[i] instanceof Torn && tipus == 3) {
                                estudiActual.getComponents()[i].showComponent();
                            }
                        }
                    }
                    break;
                    case 4:
                        for (int i = 0; i < estudiActual.getPosicioComponents(); i++) {
                            if (estudiActual.getComponents()[i] instanceof Jardiner) {
                                estudiActual.getComponents()[i].showComponent();
                            }
                        }
                    default:
                        System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                        break;
            }
        } while (opcio != 0);
    }

    public static void menuProjectes() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Assignar dissenyador o dissenyadora");
            System.out.println("\n4. Assignar jardiner o jardinera");
            System.out.println("\n5. Llista de projectes");
            opcio = DADES.nextInt();
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    estudiActual.addProjecte();
                    break;
                case 2:
                    int indexSel = estudiActual.selectComponent(4, null);
                    if (indexSel >= 0) {
                        estudiActual.getComponents()[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquest projecte");
                    }
                    break;
                case 3:
                    estudiActual.addTreballadorProjecte(1);
                    break;
                case 4:
                    estudiActual.addTreballadorProjecte(2);
                    break;
                case 5:
                    for (int i = 0; i < estudiActual.getPosicioComponents(); i++) {
                        if (estudiActual.getComponents()[i] instanceof Projecte) {
                            estudiActual.getComponents()[i].showComponent();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }


    public static Integer selectEstudi() {

        System.out.println("\nCodi de l'estudi?:");
        int codi = DADES.nextInt();

        for (int i = 0; i < posicioEstudis; i++) {
            if (estudis[i].getCodi() == codi) {
                return i;
            }
        }
        return -1;
    }

}
