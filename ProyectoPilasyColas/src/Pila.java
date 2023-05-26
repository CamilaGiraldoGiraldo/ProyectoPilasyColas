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
        int Reemplazar=0;
        boolean Encontrado = false;
        while (PilaVacia() != true && Encontrado != true) {
            dato = Desapilar();
            if (dato == d) {
                Encontrado = true;
                Reemplazar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dato:"));
                Apilar(Reemplazar);
            }
            else
            {
                Aux.Apilar(dato);
            }
        }
        Pasar_datos(Aux);
        if (Encontrado == true)
        {
            JOptionPane.showMessageDialog(null, "Dato reemplazado con éxito...");
        }
        else{
            JOptionPane.showMessageDialog(null, " Dato no encontrado...");
        }
    }

    public void EliminarDatoPila(int d, Pila Aux){
        while (!PilaVacia() && !(Vector[Tope] == d)){
            Aux.Apilar(Desapilar());
        }
        if (Vector[Tope] == d && Tope != -1){
            Desapilar();
            JOptionPane.showMessageDialog(null, "Dato eliminado con exito...");
        }else{
            JOptionPane.showMessageDialog(null, "El dato que desea eliminar no exite...");
        }
        Pasar_datos(Aux);
    }

    public void BuscarDatoPila(int d, Pila Aux){
        Boolean aprobacion = true;
        while(!PilaVacia() && aprobacion){
            if(d == Vector[Tope]){
                aprobacion= false;
            }else{
                Aux.Apilar(Desapilar());
            } 
        }
        if (!aprobacion){
            JOptionPane.showMessageDialog(null, "Dato encontrado con exito...");
        } else {
            JOptionPane.showMessageDialog(null, "Dato no encontrado...");
        }
        Pasar_datos(Aux);
    }
/*
 * public void OrdenarAscendente(Pila Aux){
 * Pila Aux2 = new Pila(Limite+1);
 * int mayor;
 * while(!PilaVacia()){
 * if (Vector[Tope] > mayor)
 * }
 * }
 */
}
        
 