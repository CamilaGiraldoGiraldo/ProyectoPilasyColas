public class Nodo {
    // atributos
    public String Materia;
    public Nodo Liga;
    public PilaLista Notas;

    public Nodo(String materia, PilaLista notas) {
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

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }

    public PilaLista getNotas() {
        return Notas;
    }

    public void setNotas(PilaLista notas) {
        Notas = notas;
    }
   
}
