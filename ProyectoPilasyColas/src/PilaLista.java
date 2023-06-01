public class PilaLista {
    NodoL Punta;
    NodoL Fin;
    public PilaLista() {
        Punta = null;
        Fin = null;
    }
    public void NuevaNota(float nota){
        NodoL nuevo = new NodoL(nota);
        apilarLista(nuevo);
    }
    
    boolean PilaListaVacia(){
        boolean aprobacion = false;
        if (Punta == null){
            aprobacion = true;

        }
        return aprobacion;
    }

    NodoL DesapilarLista(){
        NodoL dato;
        dato = Punta;
        Punta= Punta.getLiga();
        dato.setLiga(null);

        return dato;
    }

    void apilarLista (NodoL dato){
        NodoL posicion;
        if (PilaListaVacia()){
            Punta = Fin = dato;
        }else{
            posicion = Punta;
            Punta = dato;
            Punta.setLiga(posicion);
        }
    }

    void PasarDatosPilaLista(PilaLista aux){
        while(aux.PilaListaVacia()== false){
            apilarLista(aux.DesapilarLista());
        }
    }
    
}
