
import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;

public class Pila {
    // Atributos
    int Limite, Tope, Vector[];

    public Pila(int n) {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
    }

    public int getTope() {
        return Vector[Tope];
    }

    public boolean PilaVacia() {
        if (Tope == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PilaLLena() {
        boolean B = false;
        if (Tope == Limite) {
            B = true;
        }
        return B;
    }

    void Apilar(int d) {
        Tope++;
        Vector[Tope] = d;
    }

    int Desapilar() {
        int aux = Vector[Tope];
        Tope--;
        return aux;
    }

    void Pasar_datos(Pila aux) {
        int Auxiliar;
        while (aux.PilaVacia() == false) {
            Auxiliar = aux.Desapilar();
            Apilar(Auxiliar);
        }
    }

    public String Mostrar(Pila aux) {
        String s = " ";
        int Dato = 0;
        while (PilaVacia() != true) {
            Dato = Desapilar();
            s = s + "|" + Dato + "|\n ";
            aux.Apilar(Dato);
        }

        Pasar_datos(aux);
        return s;
    }

    void ReemplazarDatoPila(int d, Pila Aux) {
        int dato = 0;
        int Reemplazar = 0;
        boolean Encontrado = false;
        while (PilaVacia() != true && Encontrado != true) {
            dato = Desapilar();
            if (dato == d) {
                Encontrado = true;
                Reemplazar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dato:"));
                Apilar(Reemplazar);
            } else {
                Aux.Apilar(dato);
            }
        }
        Pasar_datos(Aux);
        if (Encontrado == true) {
            JOptionPane.showMessageDialog(null, "Dato reemplazado con éxito...");
        } else {
            JOptionPane.showMessageDialog(null, " Dato no encontrado...");
        }
    }

    public void EliminarDatoPila(int d, Pila Aux) {
        boolean aprobacion = true;
        while (!PilaVacia() && aprobacion) {
            if (d == Vector[Tope]) {
                Desapilar();
                aprobacion = false;
            } else {
                Aux.Apilar(Desapilar());
            }
        }
        if (!aprobacion) {
            JOptionPane.showMessageDialog(null, "Dato eliminado con exito...");
        } else {
            JOptionPane.showMessageDialog(null, "El dato que desea eliminar no exite...");
        }
        Pasar_datos(Aux);
    }

    public void BuscarDatoPila(int d, Pila Aux) {
        Boolean aprobacion = true;
        while (!PilaVacia() && aprobacion) {
            if (d == Vector[Tope]) {
                aprobacion = false;
            } else {
                Aux.Apilar(Desapilar());
            }
        }
        if (!aprobacion) {
            JOptionPane.showMessageDialog(null, "Dato encontrado con exito...");
        } else {
            JOptionPane.showMessageDialog(null, "Dato no encontrado...");
        }
        Pasar_datos(Aux);
    }

    public void OrdenarAscendente(Pila Aux) {
        Pila Aux2 = new Pila(Limite + 1);
        int mayor = Desapilar();
        while (!PilaVacia()) {
            if (Vector[Tope] >= mayor) {
                Aux.Apilar(mayor);
                mayor = Desapilar();
            } else {
                Aux.Apilar(Desapilar());
            }
        }
        Apilar(mayor);
        while (!Aux.PilaVacia() || !Aux2.PilaVacia()) {
            Ascendente(Aux, Aux2);
        }

    }

    public void Ascendente(Pila Aux, Pila Aux2) {
        int mayor;
        if (Aux.PilaVacia()) {
            mayor = Aux2.Desapilar();
            while (!Aux2.PilaVacia()) {
                if (Aux2.Vector[Aux2.Tope] >= mayor) {
                    Aux.Apilar(mayor);
                    mayor = Aux2.Desapilar();
                } else {
                    Aux.Apilar(Aux2.Desapilar());
                }
            }
        } else {
            mayor = Aux.Desapilar();
            while (!Aux.PilaVacia()) {
                if (Aux.Vector[Aux.Tope] >= mayor) {
                    Aux2.Apilar(mayor);
                    mayor = Aux.Desapilar();
                } else {
                    Aux2.Apilar(Aux.Desapilar());
                }
            }
        }
        Apilar(mayor);
    }

    public void OrdenarDescendente(Pila Aux) {
        Pila Aux2 = new Pila(Limite + 1);
        int menor = Desapilar();
        while (!PilaVacia()) {
            if (Vector[Tope] <= menor) {
                Aux.Apilar(menor);
                menor = Desapilar();
            } else {
                Aux.Apilar(Desapilar());
            }
        }
        Apilar(menor);
        while (!Aux.PilaVacia() || !Aux2.PilaVacia()) {
            Descendente(Aux, Aux2);
        }

    }

    public void Descendente(Pila Aux, Pila Aux2) {
        int menor;
        if (Aux.PilaVacia()) {
            menor = Aux2.Desapilar();
            while (!Aux2.PilaVacia()) {
                if (Aux2.Vector[Aux2.Tope] <= menor) {
                    Aux.Apilar(menor);
                    menor = Aux2.Desapilar();
                } else {
                    Aux.Apilar(Aux2.Desapilar());
                }
            }
        } else {
            menor = Aux.Desapilar();
            while (!Aux.PilaVacia()) {
                if (Aux.Vector[Aux.Tope] <= menor) {
                    Aux2.Apilar(menor);
                    menor = Aux.Desapilar();
                } else {
                    Aux2.Apilar(Aux.Desapilar());
                }
            }
        }
        Apilar(menor);
    }

    public void InsertarOrdenadoAscendente(int d, Pila Aux) {
        boolean aprobacion = true;
        if (PilaVacia()) {
            Apilar(d);
        } else {
            while (!PilaVacia() && aprobacion) {
                if (d > Vector[Tope]) {
                    Aux.Apilar(Desapilar());

                } else if (d <= Vector[Tope]) {
                    Apilar(d);
                    aprobacion = false;
                }

            }
            if (aprobacion) {
                Apilar(d);
            }
            Pasar_datos(Aux);
        }
    }

    public void InsertarOrdenadoDescendente(int d, Pila Aux) {
        boolean aprobacion = true;
        if (PilaVacia()) {
            Apilar(d);
        } else {
            while (!PilaVacia() && aprobacion) {
                if (d < Vector[Tope]) {
                    Aux.Apilar(Desapilar());

                } else if (d >= Vector[Tope]) {
                    Apilar(d);
                    aprobacion = false;
                }

            }
            if (aprobacion) {
                Apilar(d);
            }
            Pasar_datos(Aux);
        }
    }

    void BallSoft() {
        Pila P1 = new Pila(4);
        Pila P2 = new Pila(4);
        Pila Aux = new Pila(4);
        boolean verificacion = true;
        int mover, d;

        Apilar(1);
        Apilar(0);
        Apilar(1);
        Apilar(0);

        P1.Apilar(0);
        P1.Apilar(1);
        P1.Apilar(0);
        P1.Apilar(1);

        do {
            mover = Integer.parseInt(JOptionPane
                    .showInputDialog(
                            "Ingrese la pila que desea mover:\n 1.Mover Dato Pila 1 \n 2.Mover Dato Pila 2 \n 3. Mover Dato Pila 3 \n\n"
                                    + Mostrar(Aux) + "Pila 1 \n\n" + P1.Mostrar(Aux) + "Pila 2\n\n" + P2.Mostrar(Aux)
                                    + "Pila 3\n\n"));

            switch (mover) {

                case 1:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila 3"));
                    if (d == 2) {
                        if (P1.PilaVacia()) {
                            P1.Apilar(Desapilar());
                        } else if (P1.Vector[P1.Tope] == Vector[Tope] && !P1.PilaLLena()) {
                            P1.Apilar(Desapilar());
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }

                    } else if (d == 3) {
                        if (P2.PilaVacia()) {
                            P2.Apilar(Desapilar());
                        } else if (P2.Vector[P2.Tope] == Vector[Tope] && !P2.PilaLLena()) {
                            P2.Apilar(Desapilar());
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Movido a la misma pila...");
                    }
                    break;
                case 2:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila 3"));
                    if (d == 1) {
                        if (PilaVacia()) {
                            Apilar(P1.Desapilar());
                        } else if (Vector[Tope] == P1.Vector[P1.Tope] && !PilaLLena()) {
                            Apilar(P1.Desapilar());
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }

                    } else if (d == 3) {
                        if (P2.PilaVacia()) {
                            P2.Apilar(P1.Desapilar());
                        } else if (P2.Vector[P2.Tope] == P1.Vector[P1.Tope] && !P2.PilaLLena()) {
                            P2.Apilar(P1.Desapilar());
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Movido a la misma pila...");
                    }
                    break;
                case 3:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila 3"));
                    if (d == 1) {
                        if (PilaVacia()) {
                            Apilar(P2.Desapilar());
                        } else if (Vector[Tope] == P2.Vector[P2.Tope] && !PilaLLena()) {
                            Apilar(P2.Desapilar());
                        } else {

                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }

                    } else if (d == 2) {
                        if (P1.PilaVacia()) {
                            P1.Apilar(P2.Desapilar());
                        } else if (P1.Vector[P1.Tope] == P2.Vector[P2.Tope] && !P1.PilaLLena()) {
                            P1.Apilar(P2.Desapilar());
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Movido a la misma pila...");
                    }
                    break;
            }
            verificacion = terminar(P1, P2);
        } while (verificacion);
        JOptionPane.showMessageDialog(null,
                "****FELICITACIONES*****\nJuego terminado...\n" + Mostrar(Aux) + "Pila 1 \n\n" + P1.Mostrar(Aux)
                        + "Pila 2\n\n" + P2.Mostrar(Aux)
                        + "Pila 3\n\n");
    }

    public boolean terminar(Pila p1, Pila p2) {
        boolean ver = true;
        if (PilaLLena() && p1.PilaLLena()) {
            ver = ver();

            ver = p1.ver();
        } else if (PilaLLena() && p2.PilaLLena()) {
            ver = ver();

            ver = p2.ver();
        } else if (p1.PilaLLena() && p2.PilaLLena()) {
            ver = p1.ver();
            ver = p2.ver();
        }
        return ver;
    }

    boolean ver() {
        Pila aux = new Pila(4);
        boolean ver = true;
        aux.Apilar(Desapilar());
        while (!PilaVacia()) {
            if (aux.Vector[aux.Tope] == Vector[Tope]) {
                ver = false;

            } else {
                ver = true;
            }
            aux.Apilar(Desapilar());
        }
        Pasar_datos(aux);

        return ver;
    }

    void TorresdeHanoi() {
        Pila P2 = new Pila(4);
        Pila P3 = new Pila(4);
        Pila Aux = new Pila(4);
        int mover = 0, d = 0, valor = 0;

        Apilar(4);
        Apilar(3);
        Apilar(2);
        Apilar(1);
        JOptionPane.showMessageDialog(null, "Bienvenido al juego torres de hanoi");
        JOptionPane.showMessageDialog(null,
                " Instrucciones : \n Organice los datos en la pila 3, de tal manera que queden de mayor a menor\n"
                        + "Tenga en cuenta que: Solo puede mover un disco a la vez\n"
                        + "Además no puede colocar un dato mayor sobre uno menor.");
        for (int i = 0; i < 15 && P3.PilaLLena()==false; i++) {
            mover = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la pila que desea mover:\n 1.Mover Dato Pila 1 \n 2.Mover Dato Pila 2 \n 3. Mover Dato Pila 3 \n\n"
                            + Mostrar(Aux) + "Pila 1 \n\n" + P2.Mostrar(Aux) + "Pila 2\n\n" + P3.Mostrar(Aux)
                            + "Pila 3\n\n"));
            switch (mover) {
                case 1:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila"));
                    if (d == 2) {
                        if (P2.PilaVacia() == true) {
                            valor = Desapilar();
                            P2.Apilar(valor);
                        } else if (valor < P2.getTope() && !P2.PilaLLena()) {
                            valor = Desapilar();
                            P2.Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }

                    } else if (d == 3) {
                        if (P3.PilaVacia() == true) {
                            valor = Desapilar();
                            P3.Apilar(valor);
                        } else if (valor < P3.getTope() && !P3.PilaLLena()) {
                            valor = Desapilar();
                            P3.Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Movido a la misma pila...");
                    }
                    break;
                case 2:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila"));
                    if (d == 1) {
                        if (PilaVacia() == true) {
                            valor = P2.Desapilar();
                            Apilar(valor);
                        } else if (valor < getTope() && !PilaLLena()) {
                            valor = P2.Desapilar();
                            Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else if (d == 3) {
                        if (P3.PilaVacia() == true) {
                            valor = Desapilar();
                            P3.Apilar(valor);
                        } else if (valor < getTope() && !P3.PilaLLena()) {
                            valor = Desapilar();
                            P3.Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Movido a la misma pila...");
                    }
                    break;
                case 3:
                    d = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese a la pila que desea mover el dato: \n 1.A la Pila 1\n2.A la Pila 2\n3.A la Pila"));
                    if (d == 1) {
                        if (PilaVacia() == true) {
                            valor = P2.Desapilar();
                            Apilar(valor);
                        } else if (valor < getTope() && !PilaLLena()) {
                            valor = P2.Desapilar();
                            Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    } else if (d == 2) {
                        if (P2.PilaVacia() == true) {
                            valor = Desapilar();
                            P2.Apilar(valor);
                        } else if (valor < P2.getTope() && !P2.PilaLLena()) {
                            valor = Desapilar();
                            P2.Apilar(valor);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "Imposible mover...");
                        }
                    }
                    break;
            }

        }
        if (P3.PilaLLena() == true)
        {
            JOptionPane.showInternalMessageDialog(null, "felicitaciones ganaste...");
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null, "perdiste...");
        }
    }
}

