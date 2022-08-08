package CentroEducativo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Alumno  implements estudiante{

    private   String  dui;
    private String nombre;
    private String apeliido;
    private final int id_alumno;
    private static int Contadoralumno=1;


    List<ExEscrito> ListaEscrito= new ArrayList<ExEscrito>();

    List<ExOral> Listaoral= new ArrayList<ExOral>();



    public Alumno(String dui,String nombre,String apeliido){
        this.dui=dui;
        this.nombre=nombre;
        this.apeliido=apeliido;
        this.id_alumno=Contadoralumno ++;


    }

// se crea un metodo para mostrar examenes escritos almanenados en una lista
    public void mostrarEs(){
        Iterator<ExEscrito> it = ListaEscrito.iterator();
        // metodo boleeano hasnext que recorre la lista
        while (it.hasNext())
            System.out.println(it.next());
    }
    // se crea un metodo para mostrar examenes escritos almanenados en una lista
    public void mostrarOr( ){
        for (ExOral or: Listaoral) {
            System.out.println(or.toString());

        }

    }

    public void agregarEs(ExEscrito ex){

        ListaEscrito.add(ex);
    }

    public  void agregarOr(ExOral ex){

        Listaoral.add(ex);
    }



    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }



// se le crea la funcion que le formato de cadena
    @Override

    public String toString() {
        System.out.println("");
        return  "\n**********Alumno**********"
                + "\n Dui: " + this.dui.toString() +
                "\n Nombre: " + this.nombre.toString()+
                "\n Apellido: "+ this.apeliido.toString() +
                "\n ID_Alumno: " + this.id_alumno +
                "\n";


    }
}
