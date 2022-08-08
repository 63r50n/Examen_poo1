package CentroEducativo;

public class ExOral extends  Examen{

    private   String NivelSatifaccion;
    private  final int id_exoral;
    private static int contadorexamen=1;



    public ExOral(String fecha,String nivelSatifaccion){
        super(fecha);
        this.id_exoral=contadorexamen++;
        this.NivelSatifaccion=nivelSatifaccion;

    }

    public String getNivelSatifaccion() {
        return NivelSatifaccion;
    }

    public void setNivelSatifaccion(String nivelSatifaccion) {
        NivelSatifaccion = nivelSatifaccion;
    }

    @Override
    public String toString() {
        return "**********ExOral**********" +
                "\n" + super.toString() +
                "\n  NivelSatifaccion= " + this.NivelSatifaccion +
                "\n";
    }
}
