package com.example.demo;

import static spark.Spark.get;
import static spark.Spark.port;

public class SparkerController {

    public static void main(String[] args) {
        // Puerto en el que escuchará Spark
        port(8080);

        // Definir una ruta para descargar el archivo JAR
        get("/descargar/:archivo", (request, response) -> {
            String nombreArchivo = request.params(":archivo");
            String rutaArchivo = "archivos/" + nombreArchivo;

            // Configurar la respuesta HTTP
            response.header("Content-Disposition", "attachment; filename=" + nombreArchivo);
            return spark.utils.IOUtils.toByteArray(new java.io.FileInputStream(rutaArchivo));
        });
    }
}
