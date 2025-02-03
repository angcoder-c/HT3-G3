package com.api;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Params
 * 
 * Help:
 *      -h
 *      --help
 * From exist file
 *      --order-file <file path>
 *      --whith-algorithm <name>
 *      --dir <dir path>
 *      --output-filename <filename>
 * Generate file and 
 *      --gen-rand-nums-file
 *      --dir <dir path>
 *      --output-filename <filename>
 */

public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || IOApp.getParam(args, "-h") != null || IOApp.getParam(args, "-´-help") != null) {
            printHelp();
            return;
        }

        String orderFile = IOApp.getParam(args, "--order-file");
        String algorithm = IOApp.getParam(args, "--whith-algorithm"); 
        String dir = IOApp.getParam(args, "--dir");
        String outputFilename = IOApp.getParam(args, "--output-filename");
        boolean generateRandomFile = IOApp.getParam(args, "--gen-rand-nums-file")!=null;

        if (orderFile != null && algorithm != null && dir != null && outputFilename != null) {
            
        } else if (generateRandomFile && dir != null && outputFilename != null) {
            
        } else {
            System.out.println("ERROR: parametros insuficientes. Usa -h o --help para ver la ayuda.");
        }
    }

    private static void printHelp () {
        System.out.println("""
        
        Uso: java -cp out com.api.Main [options]
        
        Help:
            
            -h, --help => muestra un mensaje de ayuda.

        Ordenar desde un archivo existente:
            
            --order-file <file path> => la ruta a un archivo de numero para ordenar.
            --whith-algorithm <name> => nombre del algoritmo con el que se desea procesar.
            --dir <dir path> => la ruta del directorio en el que se crea el nuevo archivo.
            --output-filename <filename> => define el nombre del archivo de salida.
        
            Ejemplo:
            
            java -cp out com.api.Main --order-file ./input.txt --whith-algorithm quicksort --dir ./carpeta --output-filename ordenado.txt   

        Generar archivo con numeros aleatorios
            
            --gen-rand-nums-file => flag que crea un nuevo archivo con numero aleatorios.
            --dir <dir path> => la ruta del directorio en el que se crea el nuevo archivo..
            --output-filename <filename> => define el nombre del archivo de salida.

            Ejemplo:

            java -cp out com.api.Main --gen-rand-nums-file --dir ./carpeta --output-filename desordenado.txt       
        """);
    }
}
