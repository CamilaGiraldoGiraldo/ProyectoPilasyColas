public class nodo {
    // atributos
    public String Materia;
    public nodo Liga;
    public PilaLista Notas;

    public nodo(String materia, PilaLista notas) {
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

    public PilaLista getNotas() {
        return Notas;
    }

    public void setNotas(PilaLista notas) {
        Notas = notas;
    }
   
}
