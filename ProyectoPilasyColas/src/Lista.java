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
    
    public void ReporteNotas(){
        String reporte = "";
        String reporte2 = "";
        String reporteF = "";
        if(Punta != null){
            NodoG recorrer = Punta;
            NodoL nota;
            ColaLista aux = new  ColaLista();
            nodo paso;
            PilaLista notas = new PilaLista();
            PilaLista aux2 = new PilaLista();
            ListaR L = new ListaR();
            NodoR recorrer2;
                    do {
                reporte = reporte + " cedula: " + recorrer.getCedula() + " Nombre: " + recorrer.getNombre()
                        + " Apellidos: "
                        + recorrer.getApellido() + " Carrera: " + recorrer.getCarrera();
                if(recorrer.getMaterias().colaListaVacia()== false){
                    
                    do{
                        float suma = 0;
                        int cont = 0;
                        paso = recorrer.getMaterias().desacolarLista();
                        do{
                            nota = paso.getNotas().DesapilarLista();
                            suma = suma + nota.getNota();
                            cont ++;
                            notas.apilarLista(nota);
                        }while(paso.getNotas().PilaListaVacia()== false);
                        L.Agregar(paso.getMateria(), suma/cont);
                        aux2.PasarDatosPilaLista(notas);
                        paso.setNotas(aux2);
                        aux.encolarLista(paso);
                    }

                    while(recorrer.getMaterias().colaListaVacia() == false);
                    recorrer.setMaterias(aux);
                }
                recorrer = recorrer.getLiga();

                if(L.Punta != null){
                    recorrer2 = L.Punta;
                    do {
                        reporte2 = reporte2 + recorrer2.getNombreMateria() + recorrer2.getNota();
                        recorrer2= recorrer2.getLiga();
                    }while(recorrer2 != null);
                } 
                reporteF = reporteF + reporte + reporte2 + "\n";
            }while(recorrer != null);
        }
        JOptionPane.showMessageDialog(null, reporteF);
        reporte = "";
        reporte2 = "";
        reporteF = "";
    }
}
