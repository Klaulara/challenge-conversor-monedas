package com.alura.conversormonedas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GetRate getRate = new GetRate();

    public static void main(String[] args) {
        Map<Integer, String[]> conversions = new LinkedHashMap<>();
        conversions.put(1, new String[]{"USD", "ARS"});
        conversions.put(2, new String[]{"ARS", "USD"});
        conversions.put(3, new String[]{"USD", "BRL"});
        conversions.put(4, new String[]{"BRL", "USD"});
        conversions.put(5, new String[]{"USD", "CLP"});
        conversions.put(6, new String[]{"CLP", "USD"});

        int option = 0;

        while (option != 7) {
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                if (option >= 1 && option <= 6) {
                    String[] coins = conversions.get(option);
                    convertCoin(coins[0], coins[1]);
                } else if (option == 7) {
                    System.out.println("Muchas gracias por usar el conversor =)");
                } else {
                    System.out.println("Valor fuera de las opciones: " + option);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    private static void showMenu() {
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

    private static void convertCoin(String originCoin, String finalCoin) {
        try {
            System.out.print("Ingresa el monto a convertir: ");
            double amount = Double.parseDouble(scanner.nextLine());
            double rate = Double.parseDouble(getRate.findRate(originCoin, finalCoin).conversion_rate());
            double result = amount * rate;

            System.out.printf("%.2f %s son %.2f %s%n",
                    amount, nameCoins(originCoin), result, nameCoins(finalCoin));
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido. Asegúrese de ingresar un número.");
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio. Intente más tarde.");
        }
    }

    private static String nameCoins(String code) {
        return switch (code) {
            case "USD" -> "dólares";
            case "ARS" -> "pesos argentinos";
            case "BRL" -> "reales";
            case "CLP" -> "pesos chilenos";
            default -> code;
        };
    }
}
