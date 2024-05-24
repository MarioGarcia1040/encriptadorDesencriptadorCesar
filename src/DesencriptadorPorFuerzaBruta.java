/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase DesencriptadorPorFuerzaBruta - Desencripta por fuerza bruta comparando palabras contenida en cada resultado hasta
 encontrar coincidencias.
 Autor - Mario García. mariogarcia1040@gmail.com
 27-Abril-2024 | 19-Mayo-2024
*/
public class DesencriptadorPorFuerzaBruta {
    DesplazarCaracter desplazarCaracter = new DesplazarCaracter();
    PalabrasComunesEnEspanol palabrasComunesEnEspanol = new PalabrasComunesEnEspanol();

    void desencriptadoPorFuerzaBruta(String cadenaEncriptada, int numeroDeIntentos) {
        String resultado;
        for (int i = 1; i < numeroDeIntentos + 1; i++) {
            System.out.println("Intento #" + i);
            resultado = desplazarCaracter.desplazarCaracterDeLaCadena(cadenaEncriptada, -i); // El valor es negativo para desencriptar
            if (palabrasComunesEnEspanol.buscarPalabrasComunes(resultado)) {
                System.out.println(resultado);
                break;
            }
            System.out.println("No se encontraron coincidencias");
        }
    }
}