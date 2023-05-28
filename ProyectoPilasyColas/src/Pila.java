
import javax.swing.JOptionPane;

public class Pila {
    // Atributos
    int Limite, Tope, Vector[];

    public Pila(int n) {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
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
        Pila Aux1 = new Pila(4);
        boolean Correcto1 = false;
        boolean Correcto2 = false;
        int Mover = 0, recibir = 0, d = 0;

        P1.Apilar(1);
        P1.Apilar(2);
        P1.Apilar(1);
        P1.Apilar(2);

        P2.Apilar(2);
        P2.Apilar(1);
        P2.Apilar(2);
        P2.Apilar(1);

        JOptionPane.showMessageDialog(null, "Bienvenido al juego Ball Soft");
        JOptionPane.showMessageDialog(null, " Instrucciones : \n Organice los datos de tal manera que en la primera pila queden los 1 y en la segunda los 2.\n Apoyese en la pila principal");

        while (Correcto1 != true && Correcto2 != true) {
            Completado(P1, P2, Aux1, Correcto1, Correcto2);
            Mover = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la pila que desea mover:\n 1-Pila 1 \n 2-Pila 2 \n 3- Pila Auxiliar \n\n"
                            + P1.Mostrar(Aux1) + "Pila 1 \n\n" + P2.Mostrar(Aux1) + "Pila 2\n\n" + Aux.Mostrar(Aux1)
                            + "Pila Auxiliar\n\n"));
            if (Mover == 1) {
                if (P1.PilaVacia() != false) {
                    JOptionPane.showMessageDialog(null, "La pila 1 está vacia");
                } else {
                    d = P1.Desapilar();
                }
            } else if (Mover == 2) {
                if (P2.PilaVacia() != false) {
                    JOptionPane.showMessageDialog(null, "La pila 2 está vacia");
                } else {
                    d = P2.Desapilar();
                }
            } else {
                if (Aux.PilaVacia() != false) {
                    JOptionPane.showMessageDialog(null, "La pila auuxiliar está vacia");
                } else {
                    d = Aux.Desapilar();
                }
            }

            recibir = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la pila que va a recibir :\n 1-Pila 1 \n 2-Pila 2 \n 3- Pila Auxiliar \n"));

            if (recibir == 1) {
                if (P1.PilaLLena() != true) {
                    P1.Apilar(d);
                } else {
                    JOptionPane.showMessageDialog(null, "La pila 1 está llena");
                    if (Mover == 1)
                    {
                        P1.Apilar(d);
                    }
                    else if (Mover==2)
                    {
                        P2.Apilar(d);
                    }
                    else{
                        Aux.Apilar(d);
                    }
                }
            } else if (recibir == 2) {
                if (P2.PilaLLena() != true) {
                    P2.Apilar(d);
                } else {
                    JOptionPane.showMessageDialog(null, "La pila 2 está llena");
                    if (Mover == 1)
                    {
                        P1.Apilar(d);
                    }
                    else if (Mover==2)
                    {
                        P2.Apilar(d);
                    }
                    else{
                        Aux.Apilar(d);
                    }
                }
            } else {
                if (Aux.PilaLLena() != true) {
                    Aux.Apilar(d);
                } else {
                    JOptionPane.showMessageDialog(null, "La pila auxiliar está llena");
                    if (Mover == 1)
                    {
                        P1.Apilar(d);
                    }
                    else if (Mover==2)
                    {
                        P2.Apilar(d);
                    }
                    else{
                        Aux.Apilar(d);
                    }
                }
            }
        }

    }

    void Completado(Pila P1, Pila P2, Pila Aux1, boolean correcto1, boolean Correcto2) {
        int d = 0;
        while (P1.PilaVacia() != true && correcto1 != false) {
            d = Desapilar();
            if (d == 1) {
                correcto1 = true;
            }
            else{
                correcto1= false;
            }
            Aux1.Apilar(d);
        }
        P1.Pasar_datos(Aux1);
        while (P2.PilaVacia() != true && Correcto2 != false) {
            d = Desapilar();
            if (d == 2) {
                Correcto2 = true;
            }
            else
            {
                Correcto2=false;
            }
            Aux1.Apilar(d);
        }
        P2.Pasar_datos(Aux1);
    }
}
