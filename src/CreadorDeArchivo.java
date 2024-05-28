import java.io.File;
import java.io.IOException;
import java.nio.file.*;
/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase CreadorDeArchivo - Maneja el archivo llamado "encriptado.txt" y agrega la cadena de datos encriptados de otro archivo
 Autor - Mario García. mariogarcia1040@gmail.com
 25-Abril-2024 | 27-Mayo-2024
*/
public class CreadorDeArchivo {
    boolean crearArchivo() {
        Path rutaYNombreDelArchivo = FileSystems.getDefault().getPath("encriptado.txt");
        if (!verificarSiExisteArchivo(String.valueOf(rutaYNombreDelArchivo))) {
            try {
                Files.createFile(rutaYNombreDelArchivo);
                System.out.println("Archivo creado con éxito " + rutaYNombreDelArchivo);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo encriptado " + e.getMessage());
                System.out.println("Saliendo del programa...");
                System.exit(1);
            }
        } else {
            System.out.println("Ya existe un archivo \"encriptado.txt\", será borrado y creado nuevamente");
            borrarArchivo(String.valueOf(rutaYNombreDelArchivo));
        }
        return true;
    }
    private boolean verificarSiExisteArchivo(String rutaDelArchivo) {
        File existeArchivo = new File(rutaDelArchivo);
        return existeArchivo.exists();
    }
    void borrarArchivo(String rutaDelArchivo) {
        File archivoAborrar = new File(rutaDelArchivo);
        if (archivoAborrar.delete()) {
            System.out.println("Archivo \"encriptado.txt\" eliminado");
            crearArchivo();
        } else {
            System.out.println("No se pudo eliminar el archivo \"encriptado.txt\"");
            System.out.println("Saliendo del programa...");
            System.exit(0);
        }
    }
    void escribirCadenaEncriptada(String cadenaAescribir) {
        Path rutaYNombreDelArchivo = FileSystems.getDefault().getPath("encriptado.txt");
        try {
            Files.writeString(rutaYNombreDelArchivo, cadenaAescribir, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo \"encriptado.txt\" " + e.getMessage());
        }
    }
}