
import javax.swing.JOptionPane;

public class PilasyColas {
    public static void main(String[] args) throws Exception {
        int n = 0, d, opc, tipo;
        Boolean salirp = false;
        do {

            tipo = MenuPrincipal();
            switch (tipo) {
                case 1:
                    Boolean salir1 = false;
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
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
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
                            case 4:
                                if (P1.PilaVacia() == false) {
                                    d = Integer.parseInt(
                                            JOptionPane.showInputDialog("Ingrese un valor que desea reemplazar: "));
                                    P1.ReemplazarDatoPila(d, Aux);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 5:
                                if (P1.PilaVacia() == false) {
                                    d = Integer.parseInt(
                                            JOptionPane.showInputDialog("Ingrese el dato que desea eliminar..."));
                                    P1.EliminarDatoPila(d, Aux);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 6:
                                if (P1.PilaVacia() == false) {
                                    d = Integer.parseInt(
                                            JOptionPane.showInputDialog("Ingrese el dato que desea buscar..."));
                                    P1.BuscarDatoPila(d, Aux);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 7:
                                if (P1.PilaVacia() == false) {
                                    P1.OrdenarAscendente(Aux);
                                    JOptionPane.showMessageDialog(null, "Pila Ordenada con exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 8:
                                if (P1.PilaVacia() == false) {
                                    P1.OrdenarDescendente(Aux);
                                    JOptionPane.showMessageDialog(null, "Pila Ordenada con exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                                case 9:
                                    if (P1.PilaLLena() == false && !P1.PilaVacia()) {
                                        P1.OrdenarAscendente(Aux);
                                        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el nuevo dato que desea guardar..."));
                                        P1.InsertarOrdenadoAscendente(d, Aux);
                                    } else if (P1.PilaVacia()) {
                                        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el nuevo dato que desea guardar..."));
                                        P1.InsertarOrdenadoAscendente(d, Aux);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Pila Llena...");
                                    }
                                break;
                                case 10:
                                if (P1.PilaLLena() == false && !P1.PilaVacia()) {
                                    P1.OrdenarDescendente(Aux);
                                    d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Ingrese el nuevo dato que desea guardar..."));
                                    P1.InsertarOrdenadoDescendente(d, Aux);
                                } else if (P1.PilaVacia()) {
                                    d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Ingrese el nuevo dato que desea guardar..."));
                                    P1.InsertarOrdenadoDescendente(d, Aux);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Llena...");
                                }
                                break;
                            case 11:
                                salir1 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                break;
                        }
                    } while (!salir1);
                    break;
                case 2:
                    Boolean salir = false;
                    n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la Cola"));
                    Cola C1 = new Cola(n);
                    Cola C_Aux = new Cola(n);
                    Cola c_Aux2 = new Cola(n);
                    do {
                        opc = Menu1();
                        switch (opc) {
                            case 1:
                                if (C1.ColaLLena() == false) {
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                    C1.Encolar(d);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola  Llena...");
                                }
                                break;
                            case 2: {
                                if (C1.ColaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                } else {
                                    C1.Desacolar();
                                    JOptionPane.showMessageDialog(null, "Dato desencolado con exito...");
                                }
                            }
                                break;
                            case 3:
                                if (C1.ColaVacia() == false) {
                                    JOptionPane.showMessageDialog(null, C1.Mostrar(C_Aux));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                }
                                break;
                            case 4:
                                if (C1.ColaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                } else {
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                    C1.BuscarDatoCola(d, C_Aux);
                                }
                                break;
                            case 5:
                                if (C1.ColaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                } else {
                                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor a eliminar"));
                                    C1.EliminarDatoCola(d, C_Aux);
                                }
                                break;
                            case 6:
                                if (C1.ColaVacia() == false) {
                                    d = Integer.parseInt(
                                            JOptionPane.showInputDialog("Ingrese el dato que desea reemplazar..."));
                                    C1.ReemplazarDatoCola(d, C_Aux);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola vacia...");
                                }
                                break;
                            case 7:
                                if (C1.ColaVacia() == false) {
                                    C1.OrdenarColaAscendente(C_Aux, c_Aux2);
                                    JOptionPane.showMessageDialog(null, "Cola Ordenada con exito...");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola vacia...");
                                }
                                break;
                            case 8:
                                if (C1.ColaVacia() == false) {
                                    C1.OrdenarColaDescendente(C_Aux, c_Aux2);
                                    JOptionPane.showMessageDialog(null, "Cola Ordenada con exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola vacia...");
                                }
                                break;
                            case 9:
                                if (C1.ColaLLena() == false && !C1.ColaVacia()) {
                                    C1.OrdenarColaAscendente(C_Aux, c_Aux2);
                                    d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Ingrese el nuevo dato que desea guardar..."));
                                    C1.InsertarOrdenadoAscendente(d);
                                } else if (C1.ColaVacia()) {
                                    d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Ingrese el nuevo dato que desea guardar..."));
                                    C1.InsertarOrdenadoAscendente(d);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola Llena...");
                                }
                                break;
                                case 10:
                                    if (C1.ColaLLena() == false && !C1.ColaVacia()) {
                                        C1.OrdenarColaDescendente(C_Aux, c_Aux2);
                                        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el nuevo dato que desea guardar..."));
                                        C1.InsertarOrdenadoDescendente(d);
                                    } else if (C1.ColaVacia()) {
                                        d = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el nuevo dato que desea guardar..."));
                                        C1.InsertarOrdenadoDescendente(d);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cola Llena...");
                                    }
                                break;
                            case 11:
                                salir = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                break;
                        }
                    } while (!salir);
                    break;
                case 3:

                    salirp = true;
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                    break;
            }

        } while (!salirp);

    }

    public static int Menu() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu para Pilas ***\n\n"
                + "1.Apilar\n"
                + "2.Desapilar \n"
                + "3.Mostrar Pila\n"
                + "4.Reemplazar dato\n"
                + "5.Eliminar Dato\n"
                + "6.Buscar Dato\n"
                + "7.Ordenar Ascendente\n"
                + "8.Ordenar Descendente\n"
                + "9.Apilar Ordenado Ascendente\n"
                + "10.Apilar Ordenado Descendente\n"
                + "11.Salir"));
        return opc;
    }

    public static int MenuPrincipal() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu principal \n seleccione cual desea usar ***\n\n"
                + "1.Pilas\n"
                + "2.Colas  \n"
                + "3.Salir"));
        return opc;
    }

    public static int Menu1() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu para Colas ***\n\n"
                + "1.Encolar\n"
                + "2.Desencolar \n"
                + "3.Mostrar Cola\n"
                + "4.Buscar Dato\n"
                + "5.Eliminar Dato\n"
                + "6.Reemplazar Dato\n"
                + "7.Ordenar ascendente\n"
                + "8.Ordenar descendente\n"
                + "9.Encolar Ordenado Ascendente\n"
                + "10.Encolar Ordenado Descendente\n"
                + "11.Salir"));
        return opc;
    }
}
