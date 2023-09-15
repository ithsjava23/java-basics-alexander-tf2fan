package org.example;

import java.util.Scanner;

public class Lab15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menuChoice = 0;

        int[] antalPriser = new int[24];
        String timme;
        int minPrice = antalPriser[0];
        String minPriceTimme1 = "0";
        int maxPrice = antalPriser[0];
        String maxPriceTimme1 = "0";
        int middlePrice = antalPriser[0];
        String timma = "0";
        int sum = 0;
        int bestChargeTime;
        String menu = "Elpriser" + "\n" +
                "========" + "\n" +
                "1. Inmatning" + "\n" +
                "2. Min, Max och Medel" + "\n" +
                "3. Sortera" + "\n" +
                "4. Bästa laddningstid (4h)" + "\n" +
                "e. Avsluta";

        System.out.println("Hello there!");
        while (true) {
            System.out.print(menu);
            if (sc.hasNextInt()) {
                menuChoice = sc.nextInt();
                switch (menuChoice) {
                    case (1):
                        System.out.println("Skriv in priserna för elen varje timme i ören");
                        for (int i = 0; i < antalPriser.length; i++) {
                            timme = String.format("%02d - %02d", i, i + 1);
                            System.out.println(timme);
                            antalPriser[i] = sc.nextInt();
                        }
                        continue;
                    case (2):
                        for (int i = 0; i < antalPriser.length; i++) {
                            if (maxPrice < antalPriser[i]) {
                                maxPrice = antalPriser[i];
                                maxPriceTimme1 = String.format("%02d - %02d", i, i + 1);

                            }
                            if (minPrice > antalPriser[i]) {
                                minPrice = antalPriser[i];
                                minPriceTimme1 = String.format("%02d - %02d", i, i + 1);

                            }
                            sum += antalPriser[i];
                        }
                        middlePrice = (sum / 24);
                        System.out.println("Högsta pris : " + maxPriceTimme1 + " " + maxPrice + " öre/kWh");
                        System.out.println("Lägsta pris :" + minPriceTimme1 + " " + minPrice + " öre/kWh");
                        System.out.println("Medel pris :" + middlePrice + " öre/kWh");
                        continue;
                    case (3):
                        // Icke färdig. Ska försöka få fram den högsta talet i array till den minsta.
                        for(int i = 0;i < antalPriser.length;i++) {
                            timma = String.format("%02d - %02d",i,i+1);
                            System.out.println(timma + " " + antalPriser[i]+ " öre");
                        }
                    case (4):

                }
            } else if (sc.hasNextLine()) {
                String exit = sc.nextLine().toLowerCase();
                if (exit.equals("e")) {
                    System.exit(0);
                } else {
                    System.out.println("Fel inmating");
                }
            }
        }

    }
}
