public class Cola {
    // Atributos
    int Limite, Tope, Vector[];
    public Cola(int n)
    {
        this.Limite = n - 1;
        this.Tope = -1;
        this.Vector = new int[n];
    }

    public boolean ColaLLena() {
        boolean B = false;
        if (Tope == Limite) {
            B = true;
        }
        return B;
    }

    void Acolar(int n)
    {
        Tope++;
        Vector[Tope] = n;
    }

    int Desacolar ()
    {
        int aux = Vector [0];
        int i = 1;
        while (i != Tope)
        {
            Vector [i-1]=Vector[i];
            i++;
        }
        Tope--;
        return Vector[0];
    }
    


}
