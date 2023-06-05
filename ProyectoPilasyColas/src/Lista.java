import javax.swing.JOptionPane;

public class Lista {
    public NodoG Punta;
    public NodoG Fin;

    public Lista() {
        Punta = null;
        Fin = null;
    }

    public ListaR NuevoEstudiante(ListaR Reportes) {
       
        boolean notas = true;
        int respuesta;
        String nombre;
        String apellido;
        String cedula;
        String carrera;
        ColaLista Materias = new ColaLista();
        NodoG posicion;

        
        nombre = JOptionPane.showInputDialog("Ingrese el/los nombre del Estudiante: ");
        apellido = JOptionPane.showInputDialog("Ingrese los apellidos del Estudiante: ");
        cedula = JOptionPane.showInputDialog("Ingrese el numero de identificacion del Estudiante: ");
        carrera = JOptionPane.showInputDialog("Ingrese la carrera a la que pertenece el Estudiante: ");
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
        String Reporte = " ";
        NodoG Principal = Fin;
        ColaLista Aux = new ColaLista();
        PilaNotas Notas = new PilaNotas(4);
        PilaNotas aux = new PilaNotas(4);
        nodo materia;
        float suma = 0;
        float auxiliar = 0;

        Reporte = Reporte + " cedula: " + Principal.getCedula() + " Nombre Completo: " + Principal.getNombre()
                        + " " + Principal.getApellido() + " Carrera: " + Principal.getCarrera();
                if (Principal.getMaterias().colaListaVacia() == false) {
                    while (Principal.getMaterias().colaListaVacia() == false) {
                        materia = Principal.getMaterias().desacolarLista();
                        if (materia.getNotas().PilaVacia() == false) {
                            Notas = materia.getNotas();
                            suma = 0;
                            while (Notas.PilaVacia() == false) {
                                auxiliar = Notas.Desapilar();
                                suma = suma + auxiliar;
                                aux.Apilar(auxiliar);
                            }
                            Notas.Pasar_datos(aux);
                            materia.setNotas(Notas);
                        }
                        Aux.encolarLista(materia);
                        if ((suma/4)>=3){
                            Reporte = Reporte + " " + " " + materia.getMateria() + " " + (suma / 4)+ " Aprobado ";
                        }else{
                            Reporte = Reporte + " " + " " + materia.getMateria() + " " + (suma / 4) + " No Aprobado ";
                        }
                        
                    }
                    Principal.setMaterias(Aux);

                }
        Reportes.Agregar(Reporte);

        return Reportes;
    }
}