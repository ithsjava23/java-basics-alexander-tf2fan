package org.example;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String menuChoice = "0";

        int[] hours = new int[24];
        for(int i = 0; i < hours.length;i++) {
            hours[i] = i;
        }

        int[] antalPriser = new int[24];
        int minPrice = antalPriser[0];
        String minPriceTimme1 = "0";
        int maxPrice = antalPriser[0];
        String maxPriceTimme1 = "0";
        String middlePrice = "0";
        String timma = "0";
        String menu = """
                       Elpriser
                       ========
                       1. Inmatning
                       2. Min, Max och Medel
                       3. Sortera
                       4. Bästa Laddningstid (4h)
                       e. Avsluta
                       """;
        while (true) {
            System.out.print(menu);
                menuChoice = sc.nextLine();
                switch (menuChoice) {
                    case ("1"):
                        System.out.print("Skriv in priserna för elen varje timme i ören"+"\n");
                        for (int i = 0; i < antalPriser.length; i++) {
                            // Sortera timmerna senare så det blir 01-02 som kan användas överallt.
                            System.out.printf("%02d-%02d\n",i,i+1);
                            antalPriser[i] = sc.nextInt();
                        } sc.nextLine();
                        continue;
                    case ("2"):
                        int sum = 0;
                        maxPrice = Integer.MIN_VALUE;
                        minPrice = Integer.MAX_VALUE;
                        for (int i = 0; i < antalPriser.length; i++) {
                            if (maxPrice < antalPriser[i]) {
                                maxPrice = antalPriser[i];
                                maxPriceTimme1 = String.format("%02d-%02d", i, i + 1);

                            }
                            if (minPrice > antalPriser[i]) {
                                minPrice = antalPriser[i];
                                minPriceTimme1 = String.format("%02d-%02d", i, i + 1);

                            }
                            sum += antalPriser[i];
                        }
                        middlePrice = String.format("%.2f",(float) sum / 24);
                        System.out.print("Lägsta pris: " + minPriceTimme1 + ", " + minPrice + " öre/kWh"+"\n");
                        System.out.print("Högsta pris: " + maxPriceTimme1 + ", " + maxPrice + " öre/kWh"+"\n");
                        System.out.print("Medelpris: " + middlePrice + " öre/kWh"+"\n");
                        continue;
                    case ("3"):
                    // antalPriser[0] = 20; [1] = 30; [2] = 10; [3] = 10; [23] = 40;

                        for(int i = 0; i < antalPriser.length; i++) {
                            for(int j = i + 1;j < antalPriser.length; j++) {
                                if (antalPriser[i] < antalPriser[j]) {
                                    int tempAntal = antalPriser[i];
                                    antalPriser[i] = antalPriser[j];
                                    antalPriser[j] = tempAntal;

                                    int tempTimmar = hours[i];
                                    hours[i] = hours[j];
                                    hours[j] = tempTimmar;
                                }
                            }
                        }
                        for(int i = 0; i < antalPriser.length;i++) {
                            if (i == 3) {
                                System.out.print(String.format("%02d-%02d %d öre\n", hours[23], hours[23] + 1, antalPriser[23]));
                            } else if (i == 23) {
                                continue;
                            }
                            System.out.print(String.format("%02d-%02d %d öre\n", hours[i], hours[i] + 1, antalPriser[i]));
                            // 1st = 23-24 40 öre 24st = 02-03 10 öre;
                            // 1st = hours[0] = 23; 24st hours[
                        }
                        continue;

                    case ("4"):
                        int tempTal = antalPriser[0] + antalPriser[1] +antalPriser[2] + antalPriser[3];
                        int timma1 = 0;
                        float tempTalMedel = (float) tempTal / 4;
                        for(int i = 0;i < 21;i++) {
                            if(tempTal > antalPriser[i] + antalPriser[i+1] + antalPriser[i+2] + antalPriser[i+3]) {
                                tempTal = antalPriser[i] + antalPriser[i+1] +antalPriser[i+2] + antalPriser[i+3];
                                timma1 = i;
                                tempTalMedel = (float) tempTal / 4;
                            }

                        }
                        System.out.print(String.format("Påbörja laddning klockan %d\n",timma1));
                        System.out.print(String.format("Medelpris 4h: %.1f öre/kWh\n",tempTalMedel));
                        continue;
                    case "e","E" :
                        return;

                }
            }


    }
}
