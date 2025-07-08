import java.util.*;

public class LibretaDeNotas {

    public static void main(String[] args) {

        Map<String, List<Float>> registroEstudiante = new HashMap<>();
        Scanner ingreso = new Scanner(System.in);
        int cantidadDeAlumnos = 0, cantidadDeNotas = 0;
        float cantidadFinalNotas = 0, sumaGeneral = 0;
        String nombreEstudiante;

        System.out.println("Bienvenido al programa evaluador de clases");
        System.out.println("\nPara el correcto funcionamiento de este programa, se necesita que ingrese la cantidad de alumnos y la cantidad de notas por alumno");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

        do {
            try{
                System.out.println("[Ingrese la cantidad de alumnos]: ");
                cantidadDeAlumnos = ingreso.nextInt();
            } catch (Exception e) {
                System.out.println("El ingreso fue erroneo, el programa se va a cerrar, por favor ingrese un valor númerico la siguiente vez que corra este programa");
                break;
            }
            if (cantidadDeAlumnos <= 0) System.out.println("El valor ingresado no es válido, por lo que se intentará nuevamente, por favor ingrese un valor mayor a 0");
        }while(cantidadDeAlumnos <= 0);

        System.out.println();

        do {
            try{
                System.out.println("[Ingrese la cantidad de notas por alumno]: ");
                cantidadDeNotas = ingreso.nextInt();
                cantidadFinalNotas = cantidadFinalNotas + cantidadDeNotas;
            } catch (Exception e) {
                System.out.println("El ingreso fue erroneo, el programa se va a cerrar, por favor ingrese un valor númerico la siguiente vez que corra este programa");
                break;
            }
            if (cantidadDeNotas <= 0) System.out.println("El valor ingresado no es válido, por lo que se intentará nuevamente, por favor ingrese un valor mayor a 0");
        }while(cantidadDeNotas <= 0);

        for (int i = 1; i <= cantidadDeAlumnos; i++) {
            System.out.println("\n[Ingrese nombre del alumno número " + i + "]: ");
            nombreEstudiante = ingreso.next();
            System.out.println();
            for (int j = 1; j <= cantidadDeNotas; j++) {
                try{
                    System.out.println("[Ingrese nota número " + j + " del alumno " + nombreEstudiante + "]: ");
                    Float notaEstudiante = ingreso.nextFloat();
                    registroEstudiante.computeIfAbsent(nombreEstudiante, k -> new ArrayList<>()).add(notaEstudiante);
                } catch (Exception e) {
                    System.out.println("El ingreso fue erroneo, el programa se va a cerrar, por favor ingrese un valor númerico la siguiente vez que corra este programa");
                    System.exit(0);
                }
            }
        }

        System.out.println("------------------------\n");

        System.out.println("Notas de los estudiantes:\n");

        for (Map.Entry<String, List<Float>> entry : registroEstudiante.entrySet()){
            String estudiante = entry.getKey();
            List<Float> notas = entry.getValue();
            System.out.println("Las notas del estudiante " + estudiante + " son:");
            for (Float nota : notas){
                System.out.println(" - " + nota);
            }
            System.out.println();
        }

        System.out.println("----------------------------\n");
        System.out.println("Promedios de los estudiantes:\n");

        for (Map.Entry<String, List<Float>> entry : registroEstudiante.entrySet()){
            float suma=0, promedio, contadorPromedio=0;
            String estudiante = entry.getKey();
            List<Float> notas = entry.getValue();
            for (Float nota : notas){
                suma = suma + nota;
                contadorPromedio++;
            }
            promedio = suma/contadorPromedio;
            System.out.println("Promedio del estudiante " + estudiante + ": " + promedio);
            System.out.println();
        }

        System.out.println("-------------------------------------------\n");
        System.out.println("Notas máximas y mínimas de los estudiantes:\n");

        for (Map.Entry<String, List<Float>> entry : registroEstudiante.entrySet()){
            String estudiante = entry.getKey();
            List<Float> notas = entry.getValue();
            float notaMinima = 0, notaMaxima = 0;
            for (Float nota : notas){
                if (notaMinima == 0) notaMinima = nota;
                if (notaMinima > nota) notaMinima = nota;
                if (notaMaxima == 0) notaMaxima = nota;
                else if (notaMaxima < nota) notaMaxima = nota;
            }
            System.out.println("La nota más alta del estudiante " + estudiante + " es: " + notaMaxima);
            System.out.println("La nota más baja del estudiante " + estudiante + " es: " + notaMinima);
            System.out.println();
        }

        System.out.println();

        int opcionMenu;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("Opción 1: muestra promedio de cada estudiante");
            System.out.println("Opción 2: muestra si la nota es aprobatoria o reprobatoria por estudiante");
            System.out.println("Opción 3: muestra si la nota está por sobre o por debajo del promedio del curso, por estudiante");
            System.out.println("Opción 0: salir del programa");

            System.out.println("[Ingrese una opción]: ");
            opcionMenu = ingreso.nextInt();
            switch (opcionMenu){
                case 1:
                    System.out.println("Opción 1: Promedio por estudiante\n");

                    for (Map.Entry<String, List<Float>> entry : registroEstudiante.entrySet()){
                        float suma=0, promedio, contadorPromedio=0;
                        String estudiante = entry.getKey();
                        List<Float> notas = entry.getValue();
                        for (Float nota : notas){
                            suma = suma + nota;
                            contadorPromedio++;
                        }
                        promedio = suma/contadorPromedio;
                        System.out.println("Promedio del estudiante " + estudiante + ": " + promedio);
                        System.out.println();
                    }
                    break;
                case 2:
                    for (Map.Entry<String, List<Float>> entry : registroEstudiante.entrySet()){
                        float suma=0, promedio, contadorPromedio=0;
                        String estudiante = entry.getKey();
                        List<Float> notas = entry.getValue();
                        for (Float nota : notas){
                            suma = suma + nota;
                            contadorPromedio++;
                        }
                        promedio = suma/contadorPromedio;
                        System.out.println();
                        if (promedio<4) System.out.println("El promedio del estudiante " + estudiante + " es " + promedio + ", lo que hace que sea reprobado");
                        else System.out.println("El promedio del estudiante " + estudiante + " es " + promedio + ", el estudiante pasa");
                    }
                    break;
                case 3:
                    break;
                case 0:
                    break;
            }
        }while (opcionMenu != 0);
        System.out.println("Saliendo...");

    }

}