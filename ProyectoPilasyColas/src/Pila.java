public class Pila {
        //Atributos
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
}
