package com.api;

import java.util.ArrayList;

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

    /**
     * metodo principal para procesar los argumentos
     * dependiendo de los argumentos el programa puede:
     * 1. Ordenar un archivo de números utilizando el algoritmo de ordenamiento especificado y guardar el resultado en un archivo de salida.
     * 2. Generar un archivo de números aleatorios.
     * @param args Argumentos de la línea de comandos para el programa.
     */
    public static void main(String[] args) {
        if (args.length == 0 || IOApp.getParam(args, "-h") != null || IOApp.getParam(args, "--help") != null) {
            printHelp();
            return;
        }

        // obtiene los argumentos para ordenar
        String orderFile = IOApp.getParam(args, "--order-file");
        String algorithm = IOApp.getParam(args, "--with-algorithm");
        String dir = IOApp.getParam(args, "--dir");
        String outputFilename = IOApp.getParam(args, "--output-filename");
        boolean generateRandomFile = IOApp.getParam(args, "--gen-rand-nums-file") != null;

        if (orderFile != null && algorithm != null && dir != null && outputFilename != null) {
            ArrayList<Number> list = IOApp.readRandomList(orderFile);
            ArrayList<Number> result = new ArrayList<>();
            AlgorithmInterface sort = new Sort(list);
            System.out.println(algorithm);

            boolean validAlgorithm = true;
            switch (algorithm) {
                case "quicksort":
                    result = sort.quick();
                    break;
                case "mergesort":
                    result = sort.merge();
                    break;
                case "insertionsort":
                    result = sort.insertion();
                    break;
                case "radixsort":
                    result = sort.radix();
                    break;
                case "bucketsort":
                    result = sort.bucket();
                    break;
                default:
                    System.out.println("ERROR: algoritmo no soportado");
                    validAlgorithm = false;
                    break;
            }

            if (validAlgorithm) {
                IOApp.writeNewRandomList(dir, outputFilename, result);
                System.out.println("Archivo ordenado...");
            }

            // Si se desea generar un archivo con números aleatorios
        } else if (generateRandomFile && dir != null && outputFilename != null) {
            IOApp.writeNewRandomList(dir, outputFilename, IOApp.randomNumbers(3000));  // Escribe números aleatorios en un archivo
            System.out.println("Archivo generado...");

            // Error si los parámetros son insuficientes
        } else {
            System.out.println("ERROR: parámetros insuficientes. Usa -h o --help para ver la ayuda.");
        }
    }

    /**
     * mensaje de ayuda explicando las opciones disponibles en la línea de comandos.
     */
    private static void printHelp () {
        System.out.println("""
        
        Uso: java -cp out com.api.Main [options]
        
        Help:
            
            -h, --help => muestra un mensaje de ayuda.

        Ordenar desde un archivo existente:
            
            --order-file <file path> => la ruta a un archivo de numero para ordenar.
            --with-algorithm <name> => nombre del algoritmo con el que se desea procesar.
            --dir <dir path> => la ruta del directorio en el que se crea el nuevo archivo.
            --output-filename <filename> => define el nombre del archivo de salida.
        
            Ejemplo:
            
            java -cp out com.api.Main --order-file ./input.txt --with-algorithm quicksort --dir ./carpeta --output-filename ordenado.txt   

        Generar archivo con numeros aleatorios
            
            --gen-rand-nums-file => flag que crea un nuevo archivo con numero aleatorios.
            --dir <dir path> => la ruta del directorio en el que se crea el nuevo archivo..
            --output-filename <filename> => define el nombre del archivo de salida.

            Ejemplo:

            java -cp out com.api.Main --gen-rand-nums-file --dir ./carpeta --output-filename desordenado.txt       
        """);
    }
}
