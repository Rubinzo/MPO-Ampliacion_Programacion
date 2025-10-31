public class ControlAcceso {
private static final MyScanner sc = new MyScanner();
private static Colores color = new Colores();

public static void main(String[] args) {


    pedir_edad();

}


public  static void pedir_edad(){
    boolean flag = true;
    String mensaje = "";
    while(flag == true){

        int edad = sc.pedirNumero("Introduzca su edad: ");
        if(edad < 0){
            mensaje = color.red + "La edad no puede ser negativa"+ color.reset;

        } else if (edad == 0) {
            mensaje =color.red + "La edad no puede ser cero"+ color.reset;

        }else if (edad < 18){
            mensaje =color.red + "Acceso denegado: menor de edad" +color.reset;

        } else if (edad > 65 && edad <= 120) {
            mensaje =color.green + "Acceso con beneficios para jubilados"+ color.reset;
            flag = false;

        } else if (edad > 120){
            mensaje = color.red +"No puedes tener más de 120 años"+ color.reset;

        }else{
            mensaje =color.green + "Acceso permitido"+ color.reset;
            flag = false;

        }
        System.out.println(mensaje);
    }


}




}
