import javax.swing.JOptionPane;

public class ColaLista {
    nodo Punta;
    nodo Fin;

    public ColaLista() {
        Punta = null;
        Fin = null;
    }

    void AgregarMateria() {
        String materia = " ";
        boolean salir = false;
        int decision;
        float nota;
        PilaNotas notas = new PilaNotas(4);

        materia = JOptionPane.showInputDialog("Ingrese el nombre de las materia: ");
        while (salir == false && notas.PilaLLena()!=true) {
            decision = Integer.parseInt(JOptionPane.showInputDialog("***Desea Ingresar una nueva nota?***\n\n"
                    + "1.Si, agregar una nueva nota\n"
                    + "2.No, regresar"));

            switch (decision) {
                case 1:
                            nota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nota"));
                            notas.Apilar(nota);
                        break;
                case 2:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        }
        if (notas.PilaLLena()==true){
            JOptionPane.showMessageDialog(null, "La pila se ha llenado");
        }
        nodo nuevo = new nodo(materia, notas);
        encolarLista(nuevo);
    }

    boolean colaListaVacia() {
        boolean aprobacion = false;

        if (Punta == null) {
            aprobacion = true;
        }
        return aprobacion;
    }

    void encolarLista (nodo nuevo){
        nodo posicion;
        if (Punta == null) {
            Punta = nuevo;
            Fin = nuevo;

        } else {
            posicion = Fin;
            Fin = nuevo;
            posicion.setLiga(Fin);
        }
    }

    nodo desacolarLista() {
        nodo materia;
        
        materia = Punta;
        Punta = Punta.getLiga();
        materia.setLiga(null);
        
        return materia;
    }

    void PasarColaLista (ColaLista aux){
        while(aux.colaListaVacia() == false){
            encolarLista(aux.desacolarLista());
        }
    }

}
