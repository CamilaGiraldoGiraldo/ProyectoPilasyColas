import javax.swing.JOptionPane;

public class Cola {
    // Atributos
    int Limite, Tope, Vector[];

    public Cola(int n) {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
    }

    public boolean ColaVacia() {
        if (Tope == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ColaLLena() {
        boolean B = false;
        if (Tope == Limite) {
            B = true;
        }
        return B;
    }

    void Encolar(int n) {
        Tope++;
        Vector[Tope] = n;
    }

    int Desacolar() {
        int aux = Vector[0];
        if (Tope != 0) {
            int i = 1;
            while (i <= Tope) {
                Vector[i - 1] = Vector[i];
                i++;
            }
        }
        Tope--;
        return aux;
    }

    void PasarDatos(Cola aux) {
        int Auxiliar = 0;
        while (aux.ColaVacia() == false) {
            Auxiliar = aux.Desacolar();
            Encolar(Auxiliar);
        }
    }

    public String Mostrar(Cola aux) {
        String s = " ";
        int Dato = 0;
        while (ColaVacia() != true) {
            Dato = Desacolar();
            s = s + "|" + Dato + "|\n ";
            aux.Encolar(Dato);
        }

        PasarDatos(aux);
        return s;
    }

    void BuscarDatoCola(int d, Cola Aux) {
        int dato = 0;
        boolean Encontrado = false;
        while (ColaVacia() != true && Encontrado != true) {
            dato = Desacolar();
            if (dato == d) {
                Encontrado = true;
                Aux.Encolar(dato);
            } else {
                Aux.Encolar(dato);
            }
        }
        PasarDatos(Aux);
        if (Encontrado == true) {
            JOptionPane.showMessageDialog(null, "Dato encontrado con éxito...");
        } else {
            JOptionPane.showMessageDialog(null, " Dato no encontrado...");
        }
    }

    void EliminarDatoCola(int d, Cola Aux) {
        int dato = 0;
        boolean Encontrado = false, aprobacion = true;
        while (ColaVacia() != true) {
            dato = Desacolar();
            if (dato == d && aprobacion) {
                Encontrado = true;
                aprobacion = false;
            } else {
                Aux.Encolar(dato);
            }
        }
        PasarDatos(Aux);
        if (Encontrado == true) {
            JOptionPane.showMessageDialog(null, "Dato eliminado con éxito...");
        } else {
            JOptionPane.showMessageDialog(null, " Dato no encontrado...");
        }
    }

    void ReemplazarDatoCola(int dato, Cola Aux) {
        int d, reemplazo;
        boolean aprobacion = false, aprobacion2 = true;
        while (!ColaVacia()) {
            d = Desacolar();
            if (d == dato && aprobacion2 == true) {
                reemplazo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo Valor"));
                Aux.Encolar(reemplazo);
                aprobacion = true;
                aprobacion2 = false;
            } else {
                Aux.Encolar(d);
            }
        }
        PasarDatos(Aux);

        if (aprobacion) {
            JOptionPane.showMessageDialog(null, "Elemento reemplazado con exito...");
        } else {
            JOptionPane.showMessageDialog(null, "Dato a reemplazar no encontrado...");
        }
    }

    void OrdenarColaAscendente(Cola Aux1, Cola Aux2) {
        int menor = Desacolar();

        while (!ColaVacia()) {
            if (Vector[0] <= menor) {
                Aux1.Encolar(menor);
                menor = Desacolar();
            } else {
                Aux1.Encolar(Desacolar());
            }
        }
        Encolar(menor);
        while (!Aux1.ColaVacia() || !Aux2.ColaVacia()) {
            if (Aux1.ColaVacia()) {
                menor = Aux2.Desacolar();
                while (!Aux2.ColaVacia()) {
                    if (Aux2.Vector[0] <= menor) {
                        Aux1.Encolar(menor);
                        menor = Aux2.Desacolar();
                    } else {
                        Aux1.Encolar(Aux2.Desacolar());
                    }
                }
            } else {
                menor = Aux1.Desacolar();
                while (!Aux1.ColaVacia()) {
                    if (Aux1.Vector[0] <= menor) {
                        Aux2.Encolar(menor);
                        menor = Aux1.Desacolar();
                    } else {
                        Aux2.Encolar(Aux1.Desacolar());
                    }
                }
            }
            Encolar(menor);
        }

    }

    void OrdenarColaDescendente(Cola Aux1, Cola Aux2) {
        int mayor = Desacolar();

        while (!ColaVacia()) {
            if (Vector[0] >= mayor) {
                Aux1.Encolar(mayor);
                mayor = Desacolar();
            } else {
                Aux1.Encolar(Desacolar());
            }
        }
        Encolar(mayor);
        while (!Aux1.ColaVacia() || !Aux2.ColaVacia()) {
            if (Aux1.ColaVacia()) {
                mayor = Aux2.Desacolar();
                while (!Aux2.ColaVacia()) {
                    if (Aux2.Vector[0] >= mayor) {
                        Aux1.Encolar(mayor);
                        mayor = Aux2.Desacolar();
                    } else {
                        Aux1.Encolar(Aux2.Desacolar());
                    }
                }
            } else {
                mayor = Aux1.Desacolar();
                while (!Aux1.ColaVacia()) {
                    if (Aux1.Vector[0] >= mayor) {
                        Aux2.Encolar(mayor);
                        mayor = Aux1.Desacolar();
                    } else {
                        Aux2.Encolar(Aux1.Desacolar());
                    }
                }
            }
            Encolar(mayor);
        }
    }

    void InsertarOrdenadoAscendente(int d) {
        Cola Aux = new Cola(Limite + 1);
        boolean aprobacion = true;
        if (ColaVacia()) {
            Encolar(d);
        } else {
            while (!ColaVacia()) {
                if (d <= Vector[0] && aprobacion) {
                    Aux.Encolar(d);
                    aprobacion = false;
                } else {
                    Aux.Encolar(Desacolar());
                }
            }
            PasarDatos(Aux);
            if(aprobacion == true){
                Encolar(d);
            }
        }
    }

    void InsertarOrdenadoDescendente(int d) {
        Cola Aux = new Cola(Limite + 1);
        boolean aprobacion = true;
        if (ColaVacia()) {
            Encolar(d);
        } else {
            while (!ColaVacia()) {
                if (d >= Vector[0] && aprobacion) {
                    Aux.Encolar(d);
                    aprobacion = false;
                } else {
                    Aux.Encolar(Desacolar());
                }
            }
            PasarDatos(Aux);
            if (aprobacion == true) {
                Encolar(d);
            }
        }
    }
}