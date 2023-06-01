public class ListaR {
    NodoR Punta;
    NodoR Fin;
    public ListaR() {
        Punta = null;
        Fin = null;
    }

    public void Agregar (String Reporte) {
        NodoR Nuevo = new NodoR(Reporte);
        if (Punta == null) {
            Punta = Nuevo;
            Fin=Nuevo;
            Nuevo.setLiga(Punta);
        } else {
            Fin.setLiga(Nuevo);
            Nuevo.setLiga(null);
            Fin = Nuevo;
        }
    }

    public String Mostrar() {
        String s = " ";
        NodoR p = Punta;
        do {
            s = s + "|" + p.getReporte() + "| --> \n ";
            p = p.getLiga();
        } while (p != Punta);
        return s;
    }

    public void VaciarLista() {
        NodoR p;
        while (Punta != null) {
            p = Punta;
            Punta = p.getLiga();
            p.setLiga(null);
        }
    }
}
