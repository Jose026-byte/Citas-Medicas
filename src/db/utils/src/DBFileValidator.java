import java.io.File;
import java.io.IOException;

public class DBFileValidator {

    private static final String DB_FOLDER = "db";
    private static final String[] REQUIRED_FILES = {"doctores.txt", "pacientes.txt", "citas.txt"};

    public static void verificarOCrearArchivosDB() {
        File dbFolder = new File(DB_FOLDER);

        // Verificar si la carpeta db existe, si no, crearla
        if (!dbFolder.exists()) {
            if (dbFolder.mkdir()) {
                System.out.println("Carpeta 'db' creada correctamente.");
            } else {
                System.err.println("Error al crear la carpeta 'db'.");
                return;
            }
        }

        // Verificar y crear archivos faltantes
        for (String fileName : REQUIRED_FILES) {
            File file = new File(DB_FOLDER + File.separator + fileName);
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        System.out.println("Archivo creado: " + file.getName());
                    } else {
                        System.err.println("No se pudo crear el archivo: " + fileName);
                    }
                } catch (IOException e) {
                    System.err.println("Error al crear el archivo " + fileName + ": " + e.getMessage());
                }
            } else {
                System.out.println("El archivo " + fileName + " ya existe.");
            }
        }
    }
}