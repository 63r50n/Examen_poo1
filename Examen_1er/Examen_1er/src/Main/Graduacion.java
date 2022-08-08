package Main;
import CentroEducativo.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Graduacion {
    //Lista que tendrá alumnos aprobados
    static List<Alumno> graduacion = new ArrayList<>();

    //Lista que tendrá todos los alumnos de la clase
    static List<Alumno> clase = new ArrayList<>();


    public static void main(String[] args) {
        //Variables para capturar desde teclado
        String Dui;
        String nombre;
        String apellido;
        String fecha;
        int numexamenesEs;
        int duracion;
        double notas;
        int numeroexamenesOr;
        String nivelSatis;
        int alumno;


        // se crea objeto para pedir datos en consola
        Scanner entrada=new Scanner(System.in);

        int i=0;

        //Peticion de alumnos a ingresar al sistema
        System.out.print("Ingrese el numero de alumnos a evaluar:");
        alumno=entrada.nextInt();
        while (i<alumno){
            //Peticion de datos
            System.out.print("Ingrese su numero de DUI:");
            Dui=entrada.next();
            System.out.print("Ingresa su Nombre:");
            nombre=entrada.next();
            System.out.print("Ingrese su Apellido:");
            apellido=entrada.next();

            //Creacion del objeto alumno
            Alumno alumno1=new Alumno(Dui, nombre, apellido);

            //Peticion de examenes escritos
            System.out.print("Ingrese el numero de examenes realizados de manera escrita:");
            numexamenesEs=entrada.nextInt();

            boolean aprobado = true; //Variable que verifica si el alumno aprueba o no

            //Peticion y guardado de cada examen escrito
            for (int p=0;p<numexamenesEs;p++) {
                System.out.print("Ingrese la fecha que realizo los examenes:");
                fecha=entrada.next();
                System.out.print("Ingrese el tiempo de duracion ocupado por el examen (En minutos):");
                duracion = entrada.nextInt();
                System.out.print("Ingrese las notas:");
                notas = entrada.nextDouble();
                //Objeto del tipo Exescrito
                ExEscrito escrito = new ExEscrito(fecha, duracion, notas);

                //Agregamos el examen a la lista del objeto de tipo Alumno
                alumno1.agregarEs(escrito);

                //Verificamos si cumple las reglas de aprobación mediante el metodo Verifaprobadose
                if(Verifaprobadose(escrito) == false){
                    // se crea esta condicional para ver si la variable esta en true la cambie a false
                    if(aprobado == true)
                        // si la variable apribado esta en false esta reprobado
                        aprobado = false;
                }
            }

            //Peticion de examenes orales
            System.out.println("");
            System.out.print("Ingrese el numero de exames realizados de manera oral:");
            numeroexamenesOr = entrada.nextInt();

            //Peticion y guardado de cada examen escrito
            for (int p=0;p<numeroexamenesOr;p++) {
                System.out.print("Ingrese la fecha que realizo los examenes:");
                fecha=entrada.next();
                System.out.println("Ingrese el nivel de satifaccion obtenido:");
                System.out.println("Opciones: Insuficiente,Suficiente,Excelente:");
                nivelSatis = entrada.next();
                ExOral oral = new ExOral(fecha,
                        nivelSatis);

                //Agregamos los examenes a la lista del objeto de tipo alumno
                alumno1.agregarOr(oral);

                //Verificamos si cumple las reglas de aprobacion
                if(Verifaprobadoso(oral) == false){
                    if(aprobado == true)
                        aprobado = false;
                }
            }
            i++;
            //detalle estetico
            System.out.println("********************");

            //Verificamos si ha cumplido con todas las reglas de aprobacion
            //Si no cumple solo se agrega a la lista de la clase
            if(aprobado == false)
                clase.add(alumno1);
            else{ //Si cumple se ingresa en la lista de la clase y en la lista de graduacion
                clase.add(alumno1);
                graduacion.add(alumno1);
            }
        }

        //Muestra los alumnos de toda la clase
        System.out.println("/////Alumnos de la clase:///// ");
        for (Alumno al: clase){
            //imprimos los datos del alumno
            System.out.println(al.toString());
            //imprimimos la lista de los dos tipos de examen
            al.mostrarEs();
            al.mostrarOr();
        }

        //Muestra los alumnos que se graduaran
        System.out.println("/////Alumnos aprobados:///// ");
        for(Alumno al: graduacion){
            System.out.println(al.toString());
            al.mostrarEs();
            al.mostrarOr();
        }

    }

    //Metodos para verificar si aprueba cada examen
    public static boolean Verifaprobadose(ExEscrito escrito){
         boolean aprobado=true;
         // si la nota sea menor a 6 o la duracion sea mayor o igual
        // 90 minutos esta reprobado
         if (escrito.getNota()<6 || escrito.getDuracion()>=90.0){
             aprobado=false;

         }
        return aprobado;

    }
    public static boolean Verifaprobadoso(ExOral oral){
        boolean aprobado = true;
        // se crea una variable para comprobar el nivel de satisfaccion
        String apro=oral.getNivelSatifaccion();

        if ((apro.equals("suficiente"))||(apro.equals("excelente"))){

        }else {
            aprobado=false;
        }
        return aprobado;
    }

}
