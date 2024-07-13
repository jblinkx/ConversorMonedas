import modelos.ConvertidorDeMoneda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------------------------------------------");
            System.out.println("BIENVENIDO AL CONVERTIDOR DE MONEDA :)");
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Dólar ==> Peso Argentino");
            System.out.println("2. Peso Argentino ==> Dólar");
            System.out.println("3. Dólar ==> Real Brasileño");
            System.out.println("4. Real Brasileño ==> Dólar");
            System.out.println("5. Dólar ==> Peso Colombiano");
            System.out.println("6. Peso Colombiano ==> Dólar");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirYMostrar("USD", "ARS");
                    break;
                case 2:
                    convertirYMostrar("ARS", "USD");
                    break;
                case 3:
                    convertirYMostrar("USD", "BRL");
                    break;
                case 4:
                    convertirYMostrar("BRL", "USD");
                    break;
                case 5:
                    convertirYMostrar("USD", "COP");
                    break;
                case 6:
                    convertirYMostrar("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 7);

        scanner.close();
    }

    public static void convertirYMostrar(String monedaDesde, String monedaHacia) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();
        double montoConvertido = ConvertidorDeMoneda.convertir(monedaDesde, monedaHacia, monto);
        System.out.printf("Monto convertido: %.2f %s = %.2f %s%n", monto, monedaDesde, montoConvertido, monedaHacia);
    }
}
