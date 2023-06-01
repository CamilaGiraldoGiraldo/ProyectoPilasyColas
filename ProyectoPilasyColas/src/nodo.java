public class nodo {
    // atributos
    public String Materia;
    public nodo Liga;
    public PilaNotas Notas;

    public nodo(String materia, PilaNotas notas) {
        Materia = materia;
        Liga = null;
        Notas = notas;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public nodo getLiga() {
        return Liga;
    }

    public void setLiga(nodo liga) {
        Liga = liga;
    }

    public PilaNotas getNotas() {
        return Notas;
    }

    public void setNotas(PilaNotas notas) {
        Notas = notas;
    }
   
}
