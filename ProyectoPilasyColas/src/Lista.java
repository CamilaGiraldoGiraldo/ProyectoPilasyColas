import javax.swing.JOptionPane;

public class Lista {
    public NodoG Punta;
    public NodoG Fin;

    public Lista() {
        Punta = null;
        Fin = null;
    }

    public void NuevoEstudiante() {
        boolean notas = true;
        int respuesta;
        String nombre;
        String apellido;
        String cedula;
        String carrera;
        ColaLista Materias = new ColaLista();
        NodoG posicion;

        nombre = JOptionPane.showInputDialog("Ingrese el/los nombre del Estudiante");
        apellido = JOptionPane.showInputDialog("Ingrese los apellidos del Estudiante");
        cedula = JOptionPane.showInputDialog("Ingrese el numer de identificacion del Estudiannte");
        carrera = JOptionPane.showInputDialog("Ingrese la carrera a la que pertenece el Estudiante");
        do {
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("***Que deseas hacer?***\n"
                    + "1.Agregar Materias al estudiante\n"
                    + "2.No agregar Materias al estudiante"));
            switch (respuesta) {
                case 1:
                    Materias.AgregarMateria();
                    break;
                case 2:
                    notas = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (notas);

        NodoG estudiante = new NodoG(cedula, nombre, apellido, carrera, Materias);

        if (Punta == null) {
            Punta = estudiante;
            Fin = estudiante;
        } else {
            posicion = Fin;
            Fin = estudiante;
            posicion.setLiga(Fin);
        }

    }

    public void ReporteNotas() {
        NodoG recorrer;
        Nodo nodocola;
        NodoL nodolista;
        String primero;
        String segundo;
        String mensajeFinal ="";
        if (Punta != null) {
            recorrer = Punta;

            do {
                segundo ="";
                primero ="";

                if (recorrer.getMaterias().colaListaVacia() == false) {
                    
                    ListaR Resultados = new ListaR();
                    NodoR posicion = Resultados.Punta;
                    ColaLista auxcola = new ColaLista();
                    primero = "Nombre:  " + recorrer.getNombre() + "  Apellido:  " + recorrer.getApellido()
                            + "  Cedula:  " + recorrer.getCedula() + "  Carrera  " + recorrer.getCarrera();
                    do {
                        nodocola = recorrer.getMaterias().desacolarLista();
                        float suma = 0;
                        float cont = 0;
                        PilaLista aux = new PilaLista();
                        PilaLista aux2 = new PilaLista();
                        if (nodocola.getNotas().PilaListaVacia() == false) {
                            do {
                                nodolista = nodocola.getNotas().DesapilarLista();
                                suma = suma + nodolista.getNota();
                                cont++;
                                aux.apilarLista(nodolista);
                            } while (nodocola.getNotas().PilaListaVacia() == false);

                            aux2.PasarDatosPilaLista(aux);
                            nodocola.setNotas(aux2);
                        }
                        Resultados.Agregar(nodocola.getMateria(), suma / cont);
                        auxcola.encolarLista(nodocola);

                    } while (recorrer.getMaterias().colaListaVacia() == false);

                    recorrer.setMaterias(auxcola);
                    do {
                        segundo = "  " + segundo + posicion.getNombreMateria() + "  " + posicion.getNota();
                        posicion = posicion.getLiga();
                    } while (posicion != null);
                }

                recorrer = recorrer.getLiga();

                mensajeFinal = mensajeFinal + primero + "  " + segundo + "\n";
            } while (recorrer != null);
        }
        JOptionPane.showMessageDialog(null, mensajeFinal);
    }
}
