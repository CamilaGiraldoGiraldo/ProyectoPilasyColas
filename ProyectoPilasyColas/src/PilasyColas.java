import javax.swing.JOptionPane;

public class PilasyColas {
    public static void main(String[] args) throws Exception {
        int n = 0, d,opc;
        n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la Pila"));
        Pila P1 = new Pila(n);
        Pila Aux =new Pila (n);
        do {
            opc = Menu();
            switch (opc) {
                case 1: 
                    if (P1.PilaLLena() == false)
                    {
                        d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
                        P1.Apilar(d);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Pila Llena...");
                    }
                    break;
                case 3:
                    if (P1.PilaVacia() == false)
                    {
                        JOptionPane.showMessageDialog(null, P1.Mostrar(Aux));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Pila Vacia...");
                    }
                    break;
            }
            }
            while (opc != 4);
        }

    public static int Menu() {
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu principal ***\n\n"
                + "1.Apilar\n"
                + "2.Desapilar \n"
                + "3.Mostrar Pila\n"
                + "84. Salir"));
        return opc;
    }
    }