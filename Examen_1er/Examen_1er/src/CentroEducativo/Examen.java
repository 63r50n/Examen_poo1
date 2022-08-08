package CentroEducativo;

public class Examen {
    private String fecha;

    public Examen(){}

    public Examen(String fecha){
        super();
        this.fecha=fecha;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\n fecha=  " + this.fecha;

    }
}
