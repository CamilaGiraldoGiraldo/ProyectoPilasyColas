public class Cola {
    // Atributos
    int Limite, Tope, Vector[];

    public Cola(int n) {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
    }

    public int getTope() {
        return Tope;
    }

    public boolean ColaLLena() {
        boolean B = false;
        if (Tope == Limite) {
            B = true;
        }
        return B;
    }

    public boolean ColaVacia() {
        if (Tope == -1) {
            return true;
        } else {
            return false;
        }
    }

    void Encolar(int n) {
        Tope++;
        Vector[Tope] = n;
    }

    int Desacolar() {
        int aux = Vector[0];
        if (Tope != 0) {
            int i = 1;
            while (i != Tope) {
                Vector[i - 1] = Vector[i];
                i++;
            }
        }
        Tope--;
        return Vector[0];
    }

    void PasarDatos(Cola aux) {
        int Auxiliar;
        while (aux.ColaVacia() == false) {
            Auxiliar = aux.Desacolar();
            Encolar(Auxiliar);
        }
    }

    public String MostrarCola(Cola aux) {
        String s = " ";
        int Dato = 0;
        while (ColaVacia() != true) {
            Dato = Desacolar();
            s = s + "|" + Dato + "|\n";
            aux.Encolar(Dato);
        }
        PasarDatos(aux);
        return s;
    }
}
