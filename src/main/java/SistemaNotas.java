import java.util.Scanner;
/*Pedir 20 notas finales de alumnos en una escala de 1 a 7, manejar decimales en las notas (double).
Mostrar el promedio de las notas mayores a 5, promedio de notas inferiores a 4 y la cantidad de notas 1,
ademas mostrar el promedio total.
Ayuda: usar un bucle for que itere hasta 20 (notas) y dentro del ciclo pedir las notas una a una para
realizar los cálculos (contadores, sumas).
Opcional: si una de las notas ingresadas es 0 debe salirse del ciclo for y mostrar un mensaje de error
finalizando el programa.*/
public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nota = new double[20];
        boolean error = false;
        int contadorNota1 = 0;
        int contadorNotaInferior4 = 0;
        int contadorNotaSuperior5 = 0;
        double sumaNotaInferior4 = 0;
        double sumaNotaSuperior5 = 0;
        double sumaTotal = 0;
        double promedioInferior4 = 0;
        double promedioSuperior5 = 0;

        for (int i = 0; i < nota.length; i++) {
            System.out.println("Ingrese la nota del alumno " + (i + 1) + ": ");
            nota[i] = scanner.nextDouble();
            while (nota[i] < 0 || nota[i] > 7) {
                System.out.println("Nota inválida. Ingrese una nota entre 1 y 7: ");
                nota[i] = scanner.nextDouble();
            }
            if(nota[i] == 0) {
                error = true;
                break;
            }
            if (nota[i] == 1) {
                contadorNota1++;
            }else {
                if(nota[i] > 5) {
                    contadorNotaSuperior5++;
                    sumaNotaSuperior5 += nota[i];
                }else if(nota[i] < 4) {
                    contadorNotaInferior4++;
                    sumaNotaInferior4 += nota[i];
                }
            }
            sumaTotal += nota[i];
        }
        if (error){
            System.err.println("Error porque no pueden haber notas con valor 0, finalizando el programa, adios!!");
            System.exit(1);
        }
        //mostramos las notas 1
        System.out.println("Cantidad de notas 1: " + contadorNota1);
        //calculamos y mostramos el promedio de notas mayores a 5
        if(contadorNotaSuperior5 == 0) {
            System.out.println("Promedio de notas mayores a 5: No hay notas mayores a 5");
        } else{
            promedioSuperior5 = sumaNotaSuperior5 / contadorNotaSuperior5;
            System.out.println("Promedio de notas mayores a 5: " + promedioSuperior5);
        }
        //calculamos y mostramos el promedio de notas menores a 4
        if(contadorNotaInferior4 == 0) {
            System.out.println("Promedio de notas menores a 4: No hay notas menores a 4");
        } else{
            promedioInferior4 = sumaNotaInferior4 / contadorNotaInferior4;
            System.out.println("Promedio de notas menores a 4: " + promedioInferior4);
        }
        //calculamos y mostramos el promedio total de las notas
        double promedioTotal = sumaTotal / nota.length;
        System.out.println("Promedio total de las notas: " + promedioTotal);
    }
}