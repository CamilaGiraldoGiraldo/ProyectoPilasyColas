public class NodoL {
    float nota;
    NodoL liga;

    public NodoL(float nota) {
        this.nota = nota;
        this.liga = null;
    }
    
    public float getNota() {
        return nota;
    }
    public NodoL getLiga() {
        return liga;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }
    public void setLiga(NodoL liga) {
        this.liga = liga;
    }

}
