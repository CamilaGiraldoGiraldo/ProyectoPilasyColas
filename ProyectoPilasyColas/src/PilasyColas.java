
import javax.swing.JOptionPane;

public class PilasyColas {
    /**
     * @param args
     * @throws Exception
     */
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
                                boolean salird = false;
                                do {
                                    opc = TipoInsertar();
                                    switch (opc) {
                                        case 1:
                                            if (P1.PilaLLena() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese El Valor a Añadir..."));
                                                P1.Apilar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Llena...");
                                            }
                                            break;
                                        case 2:
                                            if (!P1.PilaVacia() && !P1.PilaLLena()) {
                                                P1.OrdenarAscendente(Aux);
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese El Valor a Añadir..."));
                                                P1.InsertarOrdenadoAscendente(d, Aux);

                                            } else if (P1.PilaVacia()) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese El Valor a Añadir..."));
                                                P1.Apilar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Llena...");
                                            }
                                            break;
                                        case 3:
                                            if (!P1.PilaVacia() && !P1.PilaLLena()) {
                                                P1.OrdenarDescendente(Aux);
                                                ;
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese El Valor a Añadir..."));
                                                P1.InsertarOrdenadoDescendente(d, Aux);

                                            } else if (P1.PilaVacia()) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese El Valor a Añadir..."));
                                                P1.Apilar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Llena...");
                                            }
                                            break;
                                        case 4:
                                            salird = true;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Ingrese una Opcion Valida...");
                                            break;
                                    }
                                } while (!salird);

                                break;
                            case 2:
                                if (P1.PilaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                } else {
                                    P1.Desapilar();
                                    JOptionPane.showMessageDialog(null, "Dato Desapilado con Exito...");
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
                                boolean salirb = false;
                                do {
                                    opc = TipoBuscar();
                                    switch (opc) {
                                        case 1:
                                            if (P1.PilaVacia() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog(
                                                                "Ingrese El Valor que Desea Reemplazar: "));
                                                P1.ReemplazarDatoPila(d, Aux);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                            }
                                            break;
                                        case 2:
                                            if (P1.PilaVacia() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog(
                                                                "Ingrese el Dato que Desea Eliminar..."));
                                                P1.EliminarDatoPila(d, Aux);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                            }
                                            break;
                                        case 3:
                                            if (P1.PilaVacia() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog(
                                                                "Ingrese el dato que desea buscar..."));
                                                P1.BuscarDatoPila(d, Aux);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                            }
                                            break;
                                        case 4:
                                            salirb = true;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                            break;
                                    }
                                } while (!salirb);
                            case 5:
                                if (P1.PilaVacia() == false) {
                                    P1.OrdenarAscendente(Aux);
                                    JOptionPane.showMessageDialog(null, "Pila Ordenada con Exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 6:
                                if (P1.PilaVacia() == false) {
                                    P1.OrdenarDescendente(Aux);
                                    JOptionPane.showMessageDialog(null, "Pila Ordenada con Exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pila Vacia...");
                                }
                                break;
                            case 7:
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
                                boolean salirf = false;
                                do {
                                    opc = TipoInsertar();
                                    switch (opc) {
                                        case 1:
                                            if (C1.ColaLLena() == false) {
                                                d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                                                C1.Encolar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola  Llena...");
                                            }
                                            break;
                                        case 2:
                                            if (!C1.ColaLLena() && !C1.ColaVacia()) {
                                                C1.OrdenarColaAscendente(C_Aux, c_Aux2);
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese el Valor a Añadir..."));
                                                C1.InsertarOrdenadoAscendente(d);
                                            } else if (C1.ColaVacia()) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese el Valor a Añadir..."));
                                                C1.Encolar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola Llena...");
                                            }
                                            break;
                                        case 3:
                                            if (!C1.ColaLLena() && !C1.ColaVacia()) {
                                                C1.OrdenarColaDescendente(C_Aux, c_Aux2);
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese el Valor a Añadir..."));
                                                C1.InsertarOrdenadoDescendente(d);
                                            } else if (C1.ColaVacia()) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog("Ingrese el Valor a Añadir..."));
                                                C1.Encolar(d);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola Llena...");
                                            }
                                            break;
                                        case 4:
                                            salirf = true;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Ingrese una Opcion Valida...");
                                            break;
                                    }

                                } while (!salirf);
                                break;
                            case 2: {
                                if (C1.ColaVacia() == true) {
                                    JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                } else {
                                    C1.Desacolar();
                                    JOptionPane.showMessageDialog(null, "Dato Desencolado con Exito...");
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
                                boolean salirbc = false;
                                do {
                                    opc = TipoBuscar();
                                    switch (opc) {
                                        case 1:
                                            if (C1.ColaVacia() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog(
                                                                "Ingrese el Valor que Desea Reemplazar: "));
                                                C1.ReemplazarDatoCola(d, c_Aux2);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                            }
                                            break;
                                        case 2:
                                            if (C1.ColaVacia() == false) {
                                                d = Integer.parseInt(
                                                        JOptionPane.showInputDialog(
                                                                "Ingrese el Dato que Desea Eliminar..."));
                                                C1.EliminarDatoCola(d, c_Aux2);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                            }
                                            break;
                                        case 3:
                                            if (C1.ColaVacia() == false) {
                                                d = Integer.parseInt(JOptionPane
                                                        .showInputDialog("Ingrese el dato que desea buscar..."));
                                                C1.BuscarDatoCola(d, C_Aux);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cola Vacia...");
                                            }
                                            break;
                                        case 4:
                                            salirbc = true;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                            break;
                                    }
                                } while (!salirbc);
                            case 5:
                                if (C1.ColaVacia() == false) {
                                    C1.OrdenarColaAscendente(C_Aux, c_Aux2);
                                    JOptionPane.showMessageDialog(null, "Cola Ordenada con Exito...");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola vacia...");
                                }
                                break;
                            case 6:
                                if (C1.ColaVacia() == false) {
                                    C1.OrdenarColaDescendente(C_Aux, c_Aux2);
                                    JOptionPane.showMessageDialog(null, "Cola Ordenada con Exito...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cola vacia...");
                                }
                                break;
                            case 7:
                                salir = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida...");
                                break;
                        }
                    } while (!salir);
                    break;
                case 3:
                    Pila P = new Pila(4);
                    boolean salirc = false;
                    int opcion;
                    do {

                        opcion = Integer
                                .parseInt(JOptionPane.showInputDialog("***Menú Juegos***\n\n"
                                        + "1.BallSort\n"
                                        + "2. Torres de hanoi\n"
                                        + "3. Salir"));
                        switch (opcion) {
                            case 1:
                                P.BallSoft();
                                break;
                            case 2:
                                P.TorresdeHanoi();
                                break;
                            case 3:
                                salirc = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una Opcion valida...");
                                break;
                        }
                    } while (!salirc);

                    break;
                case 4:
                    Lista Estudiantes = new Lista();
                    boolean salire = true;
                    int des;
                    do {
                        des = Integer.parseInt(JOptionPane
                                .showInputDialog("***Menú Reporte Notas Estudiantes***\nQue deseaa realizar?\n\n"
                                        + "1.Ingresar Estudiante al reporte\n"
                                        + "2.Generar Reporte\n"
                                        + "3.Salir"));

                        switch (des) {
                            case 1:
                                Estudiantes.NuevoEstudiante();
                                break;
                            case 2:
                            Estudiantes.ReporteNotas();
                                break;
                            case 3:
                                salire = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida....");
                                break;
                        }
                    } while (salire);

                    break;
                case 5:

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
                + "1.Apilar Datos Pila\n"
                + "2.Desapilar Datos Pila\n"
                + "3.Mostrar Datos Pila\n"
                + "4.Buscar Datos Pila\n"
                + "5.Ordenar Datos Pila Ascendente\n"
                + "6.Ordenar Datos Pila Descendente\n"
                + "7.Salir"));
        return opc;
    }

    public static int MenuPrincipal() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu principal \n seleccione cual desea usar ***\n\n"
                + "1.Pilas\n"
                + "2.Colas\n"
                + "3.Juegos\n"
                + "4.Reporte de Notas Estudiantes\n"
                + "5.Salir"));
        return opc;
    }

    public static int Menu1() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu para Colas ***\n\n"
                + "1.Encolar Datos Cola\n"
                + "2.Desencolar Datos Cola\n"
                + "3.Mostrar Datos Cola\n"
                + "4.Buscar Datos Cola\n"
                + "5.Ordenar Datos Cola Ascendente\n"
                + "6.Ordenar Datos Cola Descendente\n"
                + "7.Salir"));
        return opc;
    }

    public static int TipoBuscar() {
        int resp;
        resp = Integer.parseInt(JOptionPane.showInputDialog("*** Buscar Dato ***\n\n"
                + "1.Reemplazar Dato \n"
                + "2.Eliminar Dato \n"
                + "3.Mostrar Dato \n"
                + "4.Salir "));
        return resp;
    }

    public static int TipoInsertar() {
        int resp;
        resp = Integer.parseInt(JOptionPane.showInputDialog("***Insertar Dato***\n\n"
                + "1.Insertar Dato Desordenado\n"
                + "2.Insertar Dato Ordenado Ascendente\n"
                + "3.Insertar Dato Ordenado Descendente\n"
                + "4.Salir"));
        return resp;
    }

}
