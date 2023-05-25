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

    void BuscarDatoCola (int d, Cola Aux) {
        int dato = 0;
        boolean Encontrado = false;
        while (ColaVacia() != true && Encontrado != true) {
            dato = Desacolar();
            if (dato == d) {
                Encontrado = true;
                Aux.Encolar(dato);
            }
            else
            {
                Aux.Encolar(dato);
            }
        }
        PasarDatos(Aux);
        if (Encontrado == true)
        {
            JOptionPane.showMessageDialog(null, "Dato encontrado con éxito...");
        }
        else{
            JOptionPane.showMessageDialog(null, " Dato no encontrado...");
        }
    }

    void EliminarDatoCola(int d, Cola Aux) {
        int dato = 0;
        boolean Encontrado = false;
        while (ColaVacia() != true && Encontrado != true) {
            dato = Desacolar();
            if (dato == d) {
                Encontrado = true;
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
}