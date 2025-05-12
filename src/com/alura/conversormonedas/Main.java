package com.alura.conversormonedas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GetRate getRate = new GetRate();

    public static void main(String[] args) {
        Map<Integer, String[]> conversiones = new LinkedHashMap<>();
        conversiones.put(1, new String[]{"USD", "ARS"});
        conversiones.put(2, new String[]{"ARS", "USD"});
        conversiones.put(3, new String[]{"USD", "BRL"});
        conversiones.put(4, new String[]{"BRL", "USD"});
        conversiones.put(5, new String[]{"USD", "CLP"});
        conversiones.put(6, new String[]{"CLP", "USD"});

        int opcion = 0;

        while (opcion != 7) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion >= 1 && opcion <= 6) {
                    String[] monedas = conversiones.get(opcion);
                    convertirMoneda(monedas[0], monedas[1]);
                } else if (opcion == 7) {
                    System.out.println("Muchas gracias por usar el conversor =)");
                } else {
                    System.out.println("Valor fuera de las opciones: " + opcion);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    private static void mostrarMenu() {
        String menu = """
                *** Bienvenido/a al Conversor de Moneda de Klau =) ***
                1. Dólar => Peso Argentino
                2. Peso Argentino => Dólar
                3. Dólar => Real Brasileño
                4. Real Brasileño => Dólar
                5. Dólar => Peso Chileno
                6. Peso Chileno => Dólar
                7. Salir
                Elija una opción válida:
                *************************
                """;
        System.out.println(menu);
    }

    private static void convertirMoneda(String monedaOrigen, String monedaDestino) {
        try {
            System.out.print("Ingresa el monto a convertir: ");
            double monto = Double.parseDouble(scanner.nextLine());
            double tasa = Double.parseDouble(getRate.findRate(monedaOrigen, monedaDestino).conversion_rate());
            double resultado = monto * tasa;

            System.out.printf("%.2f %s son %.2f %s%n",
                    monto, nombreMoneda(monedaOrigen), resultado, nombreMoneda(monedaDestino));
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido. Asegúrese de ingresar un número.");
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio. Intente más tarde.");
        }
    }

    private static String nombreMoneda(String codigo) {
        return switch (codigo) {
            case "USD" -> "dólares";
            case "ARS" -> "pesos argentinos";
            case "BRL" -> "reales";
            case "CLP" -> "pesos chilenos";
            default -> codigo;
        };
    }
}
