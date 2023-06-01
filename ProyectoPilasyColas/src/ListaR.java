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
            Punta = dato;
            Fin = dato;
        }else{
        posicion = Fin;
        Fin = dato;
        posicion.setLiga(Fin);
     }
    } 

    public void VaciarLista() {
        Punta = null;
        Fin = null;
    }
}
/* 
NodoR p;while(Punta!=null)
{
            p = Punta;
            Punta = p.getLiga();
            p.setLiga(null);
        }
        */