import javax.swing.JOptionPane;

public class Cola {
    // Atributos
    int Limite, Tope, Vector[];

    public Cola(int n) {

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

    }
    
    void OrdenarColaAscendente()
    {
        int menor =0, dato=0;
        Cola Aux1 = new Cola(Limite);
        Cola Aux2 = new Cola(Limite);
        PasarDatos(Aux1);
        while (Aux1.ColaVacia()!= false || Aux2.ColaVacia() != false)
        {
            if (Aux2.ColaVacia()== true)
            {
                dato = Aux1.Desacolar();
                if(dato < menor)
                {
                    menor=dato;
                }
                else
                {
                    Aux2.Encolar(dato);
                }
            }
            else{
                dato = Aux2.Desacolar();
                if(dato < menor)
                {
                    menor=dato;
                }
                else
                {
                    Aux1.Encolar(dato);
                }
            }
        }
    }
}