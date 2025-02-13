# Hoja de trabajo 3 - Grupo 3

### Compilación

```bash
javac -d out .\src\main\java\com\api\*.java .\src\main\java\com\api\sorts\*.java .\src\test\java\com\api\*.java -cp "lib/junit-platform-console-standalone-1.11.0.jar"
```

### Ejecutar

```bash
java -cp out com.api.Main
```

**Ordenar Archivo**
```bash
java -cp out com.api.Main --order-file ./input.txt --with-algorithm quicksort --dir ./carpeta --output-filename ordenado.txt
```

| Flag | Descripción | Requerido |
|:--|:--|:--|
|`--order-file <file path>` | la ruta a un archivo de numero para ordenar | ✅ |
|`--with-algorithm <name>` | nombre del algoritmo con el que se desea procesar | ✅ |
|`--dir <dir path>` | la ruta del directorio en el que se crea el nuevo archivo | ✅ |
|`--output-filename <filename>` | define el nombre del archivo de salida | ✅ |

**Generar archivo con numeros aleatorios**

```bash
java -cp out com.api.Main --gen-rand-nums-file --dir ./carpeta --output-filename desordenado.txt
```

| Flag | Descripción | Requerido |
|:--|:--|:--|
|`--gen-rand-nums-file` | flag que crea un nuevo archivo con numero aleatorios | ✅ |
|`--dir <dir path>` | la ruta del directorio en el que se crea el nuevo archivo | ✅ |
|`--output-filename <filename>` | define el nombre del archivo de salida | ✅ |

### Test

```bash
java -jar lib/junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path
```