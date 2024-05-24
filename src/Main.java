import java.util.InputMismatchException;
import java.util.Scanner;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase principal - Muestra el menú principal del programa
 Autor - Mario García. mariogarcia1040@gmail.com
 23-Abril-2024
*/

public class Main {
    public static void main(String[] args) {
        // Scanner para capturar variables del menú
        Scanner captura = new Scanner(System.in);
        boolean terminar = false;
        int seleccion;
        // Objetos
        DesplazarCaracter encriptarDesencriptar = new DesplazarCaracter();
        LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
        CreadorDeArchivo creadorDeArchivo = new CreadorDeArchivo();

        // ciclo para mostrar el menú hasta que el usuario seleccione terminar
        while (!terminar) {
            System.out.println("\n-------------------------------");
            System.out.println("Analizador criptografico simple");
            System.out.println("-------------------------------");
            System.out.println("1.- Encriptar");
            System.out.println("2.- Desencriptar por fuerza bruta");
            System.out.println("3.- Analizador criptpgráfico");
            System.out.println("0.- Terminar");

            // bloque try-catch para prevenir error de captura, si no es un número
            try {
                System.out.print("Seleccione una opción: ");
                seleccion = captura.nextInt();

                // Creamos un ciclo switch para manejar las opciones seleccionadas
                switch (seleccion) {
                    case 1:
                        Scanner datosAprocesar = new Scanner(System.in);

                        System.out.print("Capture el nombre del archivo a encriptar: ");
                        String archivoAprocesar = datosAprocesar.nextLine();
                        System.out.println("\nTexto del archivo:\n " + lectorDeArchivo.leerArchivo(archivoAprocesar) + "\n");
                        System.out.print("Capture la clave de encriptación: ");
                        int clave = datosAprocesar.nextInt();
                        System.out.println("\nResultado: ");
                        String cadenaProcesada = encriptarDesencriptar.desplazarCaracterDeLaCadena(lectorDeArchivo.leerArchivo(archivoAprocesar), clave);

                        if (creadorDeArchivo.crearArchivo()) {
                            creadorDeArchivo.escribirCadenaEncriptada(cadenaProcesada);
                        }

                        System.out.println("Cadena encriptada: " + cadenaProcesada);

                        break;

                    case 2:
                        DesencriptadorPorFuerzaBruta desencriptadorPorFuerzaBruta = new DesencriptadorPorFuerzaBruta();
                        datosAprocesar = new Scanner(System.in);

                        System.out.print("Capture el nombre del archivo a desencriptar por fuerza bruta: ");
                        archivoAprocesar = datosAprocesar.nextLine();
                        System.out.println("Texto encriptado: " + lectorDeArchivo.leerArchivo(archivoAprocesar));
                        System.out.print("Determina el número de intentos: ");
                        int intentos = datosAprocesar.nextInt();
                        desencriptadorPorFuerzaBruta.desencriptadoPorFuerzaBruta(lectorDeArchivo.leerArchivo(archivoAprocesar), intentos);

                        break;

                    case 3:
                        AnalisCriptograficoPorFrecuencias analisCriptograficoPorFrecuencias = new AnalisCriptograficoPorFrecuencias();
                        datosAprocesar = new Scanner(System.in);

                        System.out.println("\nDesencriptar archivo por frecuencias estadistícas");
                        System.out.print("\nCapture el nombre del archivo a analizar: ");
                        archivoAprocesar = datosAprocesar.nextLine();
                        System.out.println("Texto encriptado: " + lectorDeArchivo.leerArchivo(archivoAprocesar));
                        analisCriptograficoPorFrecuencias.caracterQueMasApareceEnTexto(lectorDeArchivo.leerArchivo(archivoAprocesar));
                        //analisCriptograficoPorFrecuencias.encontrarClaveConCaracterComun();
                        //analisCriptograficoPorFrecuencias.probarClaveDeCaracterComun(lectorDeArchivo.leerArchivo(archivoAprocesar));
                        //analisCriptograficoPorFrecuencias.probarClavesObtenidasDeCaracteresComunes();

                        break;

                    case 0:
                        System.out.println("\nSaliendo del programa...");

                        terminar = true;

                        break;

                    default:
                        System.out.println("Solo números entre 0 y 2");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nNo capturó un número, reintente\n");
                captura.next();
            }
        }
    }
}