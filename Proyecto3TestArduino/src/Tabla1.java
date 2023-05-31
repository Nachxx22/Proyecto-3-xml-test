public class Tabla1 {
    static String[][] Datos ={{"ID","Nombre","Edad","Carrera","Curso"},
            {"3322","Carlos","24","Computadores","Datos"},
            {"1024","Felipe","20","Industrial","Calculo"}
            ,{"3052","Juan","22","Electronica","Fisica"},
            {"2060","Jose","25","Computadores","Calculo"}};
public static void main(String[] args){
    XMLCreate.XMLcrear(Datos,"Estudiantes");

}
}
