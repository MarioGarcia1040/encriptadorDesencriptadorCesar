/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase EncriptadorDesencriptador - Encripta y desencripta con el método césar
 Autor - Mario García. mariogarcia1040@gmail.com
 24-Abril-2024
*/
public class EncriptadorDesencriptador {
    private char procesarCaracter(char caracter, int clave) {
        int caracterDesplazado = caracter + clave;
        return (char) caracterDesplazado;
    }

    String procesarCadena(String cadenaSinProcesar, int clave) {
        if (clave == 0) {
            System.out.println("La clave con valor 0 no altera los datos originales");
            return cadenaSinProcesar;
        }
        StringBuilder cadenaProcesada = new StringBuilder();
        for (int i = 0; i < cadenaSinProcesar.length(); i++) {
            char caracterSinProcesar = cadenaSinProcesar.charAt(i);
            char caracterProcesado = procesarCaracter(caracterSinProcesar, clave);
            cadenaProcesada.append(caracterProcesado);
        }
        return cadenaProcesada.toString();
    }
}