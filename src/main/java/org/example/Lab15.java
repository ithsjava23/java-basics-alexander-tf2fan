package org.example;

import java.util.Scanner;

public class Lab15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menuChoice = 0;

        int[] antalPriser = new int[24];
        String timme1;
        String timme2;
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
                        System.out.println("Skriv in priserna för elen varje timme i ören");
                        for (int i = 0; i < antalPriser.length; i++) {
                            timme1 = String.format("%02d",i);
                            timme2 = String.format("%02d",(i+1));
                            System.out.println(timme1+"-"+timme2);
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
                        System.out.println("Högsta pris = "+maxPrice);
                        System.out.println("Lägsta pris = "+minPrice);
                        System.out.println("Medel pris = "+middlePrice);
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
