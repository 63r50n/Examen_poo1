package CentroEducativo;

public class ExEscrito  extends  Examen{

    private double Duracion;
    private double Nota;
    private final int id_escrito;
    private static  int contadorexamen=1;


    public ExEscrito(String fecha, double duracion, double nota){
        // es crea el metodo super para enviar fecha a clase padre(examen)
        super(fecha);
        this.id_escrito=contadorexamen++;
        this.Duracion=duracion;
        this.Nota=nota;

    }

    public double getDuracion() {
        return Duracion;
    }

    public void setDuracion(double duracion) {
        Duracion = duracion;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double nota) {
        Nota = nota;
    }

    @Override
    public String toString() {
        return "\n**********ExEscrito**********" +
                "\n" + super.toString() +
                "\n Duracion=  " + this.Duracion +
                "\n Nota= " + this.Nota +
                "\n id_escrito= " + this.id_escrito +
                "\n";
    }
}

