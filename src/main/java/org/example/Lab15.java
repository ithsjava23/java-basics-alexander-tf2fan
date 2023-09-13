package org.example;

import java.util.Scanner;

public class Lab15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menuChoice = 0;

        int[] antalPriser = new int[24];
        int minPrice = antalPriser[0];
        int maxPrice = antalPriser[0];
        int middlePrice = antalPriser[0];
        int sum = 0;
        int bestChargeTime;
        String menu = """
                Elpriser\s
                ========\s
                1. Inmatning\s
                2. Min, Max och medel\s
                3. Sortera\s
                4. Bästa laddningstid\s
                e. Avsluta""";
        while (true) {
            System.out.println(menu);
            if (sc.hasNextInt()) {
                menuChoice = sc.nextInt();
                switch (menuChoice) {
                    case (1):
                        System.out.println("Skriv in priser för all 24 timmar i ören");
                        for (int i = 0; i < antalPriser.length; i++) {
                            System.out.println("Timme mellan " + i + "-" + (i + 1));
                            antalPriser[i] = sc.nextInt();
                        }
                        continue;
                    case (2):
                        for(int i = 0;i < antalPriser.length;i++) {
                            if (maxPrice < antalPriser[i]) {
                                maxPrice = antalPriser[i];
                            }
                            if (minPrice > antalPriser[i]) {
                                minPrice = antalPriser[i];
                            }
                            sum += antalPriser[i];
                        }
                        middlePrice = (sum / 24);
                        System.out.println(middlePrice);
                        }

            } else if (sc.hasNextLine()) {
                char exit = sc.next().charAt(0);
                switch (exit) {
                    case 'e':
                    case 'E':
                        System.out.println(1);
                        break;
                    default:
                        System.out.println("Fel inmating");
                }
            }
        }

    }
}
