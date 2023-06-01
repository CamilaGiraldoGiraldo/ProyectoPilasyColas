public class NodoR {
    String Reporte;
    NodoR liga;


    public NodoR(String reporte) {
        Reporte = reporte;
        this.liga = null;
    }

    public NodoR getLiga() {
        return liga;
    }

    public void setLiga(NodoR liga) {
        this.liga = liga;
    }

    public String getReporte() {
        return Reporte;
    }

    public void setReporte(String reporte) {
        Reporte = reporte;
    }
   
}
