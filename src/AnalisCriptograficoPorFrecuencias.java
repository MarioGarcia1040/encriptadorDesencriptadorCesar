/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase AnalisisCriptograficoPorFrecuencias - Se busca las letras con mas frecuencias de uso en el lenguaje al ser encon-
 trada alguna de estas se usa la clave de encriptación para desencriptar el archivo y validar el texto buscando palabras
 comunes del idioma, buscando reducir el número de intentos.
 Autor - Mario García. mariogarcia1040@gmail.com
 19-Mayo-2024 | 23-Mayo-2024
*/

import java.util.*;

public class AnalisCriptograficoPorFrecuencias {
    DesplazarCaracter desplazarCaracter = new DesplazarCaracter();
    PalabrasComunesEnEspanol palabrasComunesEnEspanol = new PalabrasComunesEnEspanol();
    void caracterQueMasApareceEnTexto(String textoAAnalizar) {
        textoAAnalizar = textoAAnalizar.toLowerCase();
        Map<Character, Integer> numeroDeCaracteresEncontrados = new HashMap<Character, Integer>();
        for (int i = 0; i < textoAAnalizar.length(); i++) {
            char caracterAAnalizar = textoAAnalizar.charAt(i);
            if (!numeroDeCaracteresEncontrados.containsKey(caracterAAnalizar)) {
                numeroDeCaracteresEncontrados.put(caracterAAnalizar, 1);
            } else {
                numeroDeCaracteresEncontrados.put(caracterAAnalizar, numeroDeCaracteresEncontrados.get(caracterAAnalizar) + 1);
            }
        }
        int mayorNumeroDeApariciones = 0;
        char caracterMasComun = 0;
        for (Map.Entry<Character, Integer> entry : numeroDeCaracteresEncontrados.entrySet()) {
            if (entry.getValue() > mayorNumeroDeApariciones) {
                mayorNumeroDeApariciones = entry.getValue();
                caracterMasComun = entry.getKey();
            }
        }
        System.out.println("Caracter más común en el texto: \"" + caracterMasComun + "\" aparece: " + mayorNumeroDeApariciones);
        desencriptarConClaveDeCaracterComun(caracterMasComun, textoAAnalizar);
    }
    void desencriptarConClaveDeCaracterComun(char caracterMasComun, String cadenaEncriptada) {
        char[] caracteresComunesEnElIdioma = {' ', 'a', 'e', 'o', 's', 'r', 'n', 'i', 'l', 'd', 'u', 't'};
        for (int i = 0; i < caracteresComunesEnElIdioma.length; i++) {
            int valorDeClaveObtenida = caracteresComunesEnElIdioma[i] - caracterMasComun;
            System.out.println("Caracter común: " + caracteresComunesEnElIdioma[i] + " caracter con mas apariciones: " + caracterMasComun);
            System.out.println("Clave encontrada: " + valorDeClaveObtenida);
            String resultado = desplazarCaracter.desplazarCaracterDeLaCadena(cadenaEncriptada, valorDeClaveObtenida);
            if (palabrasComunesEnEspanol.buscarPalabrasComunes(resultado)) {
                System.out.println(resultado);
                break;
            }
            System.out.println("No se encontraron coincidencias");
        }
    }
}