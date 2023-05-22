import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;

public class PilasyColas {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int n = 0, d, opc, tipo;
        do {
            tipo = MenuPrincipal();
            switch (tipo) {
                case 1:
                    n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la Pila"));
                    Pila P1 = new Pila(n);
                    Pila Aux = new Pila(n);
                    do {
                        opc = Menu();
                        switch (opc) {
                            case 1:
                                if (P1.PilaLLena() == false) {
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                    P1.Apilar(d);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Llena...");
                                }
                                break;
                            case 2:
                                if (P1.PilaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Pila Llena...");
                                } else {
                                    P1.Desapilar();
                                    JOptionPane.showMessageDialog(null, "Dato desapilado con exito...");
                                }
                                break;
                            case 3:
                                if (P1.PilaVacia() == false) {
                                    JOptionPane.showMessageDialog(null, P1.Mostrar(Aux));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                        }
                    } while (opc != 4);
                    break;
                case 2:
                    n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la Cola"));
                    Cola C1 = new Cola(n);
                    Cola Auxiliar = new Cola (n);
                    do {
                        opc = Menu1();
                        switch (opc) {
                            case 1:
                                if (C1.ColaLLena() == false) {
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                    C1.Acolar(d);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola  Llena...");
                                }
                                break;
                            case 2:
                                {
                                    if (C1.ColaLLena() == false) {
                                        d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                        C1.Desacolar();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cola Llena...");
                                    }
                                }
                                break;
                            case 3:
                                if (C1.ColaVacia() == false) {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, C1.Mostrar_Cola());
                                }
                                break;
                        }
                    } while (opc != 4);
                    break;
            }
        } while (tipo != 3);
    }

    public static int Menu() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu para Pilas ***\n\n"
                + "1.Apilar\n"
                + "2.Desapilar \n"
                + "3.Mostrar Pila\n"
                + "4. Salir"));
        return opc;
    }

    public static int MenuPrincipal() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu principal \n seleccione cual desea usar ***\n\n"
                + "1.Pilas\n"
                + "2.Colas  \n"
                + "3. Salir"));
        return opc;
    }

    public static int Menu1() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu para Pilas ***\n\n"
                + "1.Acolar\n"
                + "2.Desacolar \n"
                + "3.Mostrar Cola\n"
                + "4. Salir"));
        return opc;
    }
}