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
        float nota;
        PilaNotas notas = new PilaNotas(4);

        materia = JOptionPane.showInputDialog("Ingrese el nombre de las materia: ");
        while (notas.PilaLLena() != true) {

            nota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nota"));
            if (nota >= 0 && nota <= 5) {
                notas.Apilar(nota);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una nota valida...");
            }

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

    void encolarLista(nodo nuevo) {
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
        if (!colaListaVacia()) {
            materia = Punta;
            Punta = Punta.getLiga();
            materia.setLiga(null);
        } else {
            materia = null;
        }

        return materia;
    }

    void PasarColaLista(ColaLista aux) {
        while (aux.colaListaVacia() == false) {
            encolarLista(aux.desacolarLista());
        }
    }

}
