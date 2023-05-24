import javax.swing.JOptionPane;

public class Cola {
    // Atributos
    int Limite, Tope, Vector[];

    public Cola(int n)
    {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
    }

    public boolean ColaVacia()
    {
        if (Tope == -1)
        {
            return true;
        }else
        {
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

    void Encolar(int n)
    {
        Tope++;
        Vector[Tope] = n;
    }

    int Desacolar (){
    
        int aux = Vector [0];
        if (Tope != 0)
        {
            int i = 1;
            while (i <= Tope) {
                Vector[i - 1] = Vector[i];
                i++;

            }
        }
        Tope--;
        return aux;
    }
    void PasarDatos (Cola aux)
    {
        int Auxiliar;
        while (aux.ColaVacia() == false){
            Auxiliar = aux.Desacolar();
            Encolar(Auxiliar);
        }
    }
    public String Mostrar_Cola(){
        Cola Aux = new Cola(Limite + 1);
        String s = " ";
        int Dato = 0;
        while (ColaVacia() != true)
        {
            Dato = Desacolar();
            s = s + "|" + Dato + "|\n ";
            Aux.Encolar(Dato);
        }
        PasarDatos(Aux);
        return s;
    }
}