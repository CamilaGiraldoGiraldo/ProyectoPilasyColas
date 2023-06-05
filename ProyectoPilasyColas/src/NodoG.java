public class NodoG {
    public String Cedula;
    public String Nombre;
    public String Apellido;
    public NodoG Liga;
    public String Carrera;
    public ColaLista Materias;

    public NodoG(String cedula, String nombre, String apellido, String carrera, ColaLista materias) {
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Liga = null;
        Carrera = carrera;
        Materias = materias;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public NodoG getLiga() {
        return Liga;
    }

    public void setLiga(NodoG liga) {
        Liga = liga;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public ColaLista getMaterias() {
        return Materias;
    }

    public void setMaterias(ColaLista materias) {
        Materias = materias;
    }

}
