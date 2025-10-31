public class ControlAcceso {
private static final MyScanner sc = new MyScanner();
private static Colores color = new Colores();

public static void main(String[] args) {


    pedir_edad();

}


public  static void pedir_edad(){
    boolean flag = true;
    String mensaje = "";
    int intentos = 0;
    while(flag == true){

        int edad = sc.pedirNumero("Introduzca su edad: ");
        if(intentos == 3){
            System.out.println(color.red + "Has intentado más de 3 veces vuelve a intentarlo en un rato"+ color.reset);
            flag = false;
            break;
        } else if(edad < 0){
            mensaje = color.red + "La edad no puede ser negativa"+ color.reset;
            intentos = intentos + 1;

        } else if (edad == 0) {
            mensaje =color.red + "La edad no puede ser cero"+ color.reset;
            intentos = intentos + 1;

        }else if (edad < 18){
            mensaje =color.red + "Acceso denegado: menor de edad" +color.reset;
            intentos = intentos + 1;

        } else if (edad > 65 && edad <= 120) {
            mensaje =color.green + "Acceso con beneficios para jubilados"+ color.reset;
            flag = false;

        } else if (edad > 120){
            mensaje = color.red +"No puedes tener más de 120 años"+ color.reset;
            intentos = intentos + 1;


        }else{
            mensaje =color.green + "Acceso permitido"+ color.reset;
            flag = false;

        }
        System.out.println(mensaje);
    }


}




}
