public class Alumno {
//Declarar variables sin inicializar
private String nombre;
private double notaProgramacion;
private double notaBaseDatos;
private double notaSistemasInformaticos;
private double notaMedia;

//Instanciar la clase MyScanner
private static final MyScanner sc = new MyScanner();
//Constructor vacío para que el usuario introduzca los datos


    public Alumno() {
        this.nombre = nombre;
        this.notaProgramacion = notaProgramacion;
        this.notaBaseDatos = notaBaseDatos;
        this.notaSistemasInformaticos = notaSistemasInformaticos;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaProgramacion() {
        return notaProgramacion;
    }

    public void setNotaProgramacion(double notaProgramacion) {
        this.notaProgramacion = notaProgramacion;
    }

    public double getNotaBaseDatos() {
        return notaBaseDatos;
    }

    public void setNotaBaseDatos(double notaBaseDatos) {
        this.notaBaseDatos = notaBaseDatos;
    }

    public double getNotaSistemasInformaticos() {
        return notaSistemasInformaticos;
    }

    public void setNotaSistemasInformaticos(double notaSistemasInformaticos) {
        this.notaSistemasInformaticos = notaSistemasInformaticos;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    //Metodo para crear Alumnos
    public void Alumno() {
        //Boleano para controlar que las notas están entre 1-10
        boolean nombreValida = true;
        boolean notaProValida = true;
        boolean notaBaDaValida = true;
        boolean notaSiInValida = true;
        boolean flag = true;
        while (flag) {
            //Con este bucle controlo que si se equivoca en un paso no vuelva a hacer todos los anteriores
            if(nombreValida) {
                this.nombre = sc.pedirSoloTexto("Introduce el nombre del alumno: ");
                nombreValida = false;

            }
            if(notaProValida){
                this.notaProgramacion = sc.pedirDecimal("Introduce tu nota de programación: ");
                //Control de excepciones
                if (notaProgramacion > 10 || notaProgramacion < 0) {
                    System.out.println("La nota tiene que estar entre 0-10");
                    continue;
                }
                //Si la nota es correcta que no vuelva a preguntarla si se repite el bucle
                notaProValida = false;
            }
            if(notaBaDaValida) {
                this.notaBaseDatos = sc.pedirDecimal("Introduce tu nota de base de datos: ");
                if (notaBaseDatos > 10 || notaBaseDatos < 0) {
                    System.out.println("La nota tiene que estar entre 0-10");
                    continue;
                }
                notaBaDaValida = false;
            }

            if(notaSiInValida) {
                this.notaSistemasInformaticos = sc.pedirDecimal("Introduce tu nota de sistemas informáticos: ");
                if (notaSistemasInformaticos > 10 || notaSistemasInformaticos < 0) {
                    System.out.println("La nota tiene que estar entre 0-10");
                    continue;
                }
                notaSiInValida = false;
            }
            //Calcular media
            notaMedia = ((notaProgramacion + notaBaseDatos + notaSistemasInformaticos)/3);
            //Mostrar mensaje en base a la media
            if(notaMedia >= 5){
                datosAlumno();
                System.out.println("\nAprobado");
            } else if (notaMedia < 5) {
                datosAlumno();
                System.out.println("\nSuspenso");
            }
            flag = false;

        }
    }
    //Metodo para mostrar todos los datos de los alumnos
    public void datosAlumno(){
        System.out.println("=====Datos del alumno " + this.nombre + "=====");
        System.out.println("Nota programacion: " +  notaProgramacion);
        System.out.println("Nota base datos: " +  notaBaseDatos);
        System.out.println("Nota sis inf: " +  notaSistemasInformaticos);
        //Redondear la media al segundo decimal
        System.out.printf("Nota media: %.2f" ,  notaMedia);

    }
}
