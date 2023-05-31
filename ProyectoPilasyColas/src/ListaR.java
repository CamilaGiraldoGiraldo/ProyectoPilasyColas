public class ListaR {
    NodoR Punta;
    NodoR Fin;
    public ListaR() {
        Punta = null;
        Fin = null;
    }

    void Agregar(String materia, float nota){
        NodoR dato = new NodoR(materia, nota);
        NodoR posicion;
        if (Punta == null){
            Punta = Fin = dato;
        }else{
        posicion = Fin;
        Fin = dato;
        posicion.setLiga(Fin);
     }
    } 
}
