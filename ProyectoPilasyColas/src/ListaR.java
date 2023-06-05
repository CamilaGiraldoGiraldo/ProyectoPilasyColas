public class ListaR {
    NodoR Punta;
    NodoR Fin;

    public ListaR() {
        Punta = null;
        Fin = null;
    }

    public void Agregar(String Reporte) {
        NodoR Nuevo = new NodoR(Reporte);
        NodoR posicion;
        if (Punta == null) {
            Punta = Nuevo;
            Fin = Nuevo;
        } else {
            posicion = Fin;
            Fin = Nuevo;
            posicion.setLiga(Fin);
        }
    }

    public String Mostrar() {
        String s = " ";
        NodoR p = Punta;
        do {
            s = s + "|" + p.getReporte() + "| --> \n ";
            p = p.getLiga();
        } while (p != null);
        return s;
    }

}
