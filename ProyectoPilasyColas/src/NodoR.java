public class NodoR {
    String nombreMateria;
    float nota;
    NodoR liga;

    public NodoR(String nombreMateria, float nota) {
        this.nombreMateria = nombreMateria;
        this.nota = nota;
        this.liga = null;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public NodoR getLiga() {
        return liga;
    }

    public void setLiga(NodoR liga) {
        this.liga = liga;
    }
   
}
