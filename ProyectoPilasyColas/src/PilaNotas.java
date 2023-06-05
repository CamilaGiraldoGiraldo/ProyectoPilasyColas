public class PilaNotas {
    // Atributos
    int Limite, Tope;
    float Vector[];

    public PilaNotas(int n) {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new float[n];
    }

    public float getTope() {
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

    void Apilar(float a) {
        Tope++;
        Vector[Tope] = a;
    }

    float Desapilar() {
        float aux = Vector[Tope];
        Tope--;
        return aux;
    }

    void Pasar_datos(PilaNotas aux) {
        float Auxiliar;
        while (aux.PilaVacia() == false) {
            Auxiliar = aux.Desapilar();
            Apilar(Auxiliar);
        }
    }

    public String Mostrar(PilaNotas aux) {
        String s = " ";
        float Dato = 0;
        while (PilaVacia() != true) {
            Dato = Desapilar();
            s = s + "|" + Dato + "|\n ";
            aux.Apilar(Dato);
        }

        Pasar_datos(aux);
        return s;
    }
}
