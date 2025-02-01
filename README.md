# Hoja de trabajo 3 - Grupo 3

### Compilación

`javac -d out src/main/java/com/api/*.java src/test/java/com/api/*.java -cp "lib/junit-platform-console-standalone-1.11.0.jar"`

### Ejecutar

`java -cp out com.api.Main`


### Test

`java -jar lib/junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path`