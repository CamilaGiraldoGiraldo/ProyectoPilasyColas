import javax.swing.JOptionPane;

public class ColaLista {
    Nodo Punta;
    Nodo Fin;

    public ColaLista() {
        Punta = null;
        Fin = null;
    }

    void AgregarMateria() {
        String materia = JOptionPane.showInputDialog("Ingrese el nombre de las materia");
        PilaLista notas = new PilaLista();
        boolean salir = true;
        int decision, nota;

        do {
            decision = Integer.parseInt(JOptionPane.showInputDialog("***Desea Ingresar una nueva nota?***\n\n"
                    + "1.Si, agregar una nueva nota\n"
                    + "2.No, regresar"));

            switch (decision) {
                case 1:
                    nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota"));
                    notas.NuevaNota(nota);
                    break;
                case 2:
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (salir);
        Nodo nuevo = new Nodo(materia, notas);
        encolarLista(nuevo);
        
    }

    boolean colaListaVacia() {
        boolean aprobacion = false;

        if (Punta == null) {
            aprobacion = true;
        }
        return aprobacion;
    }

    void encolarLista (Nodo nuevo){
        Nodo posicion;
        if (Punta == null) {
            Punta = nuevo;
            Fin = nuevo;

        } else {
            posicion = Fin;
            Fin = nuevo;
            posicion.setLiga(Fin);
        }
    }

    Nodo desacolarLista() {
        Nodo materia;
        
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
