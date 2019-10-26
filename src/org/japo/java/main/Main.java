/* 
 * Copyright 2019 Elísabet Palomino .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elísabet Palomino
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Random RND = new Random();

    public static void main(String[] args) {

        //Constantes
        final int M_MAX = 23 * 60 + 59;
        final double TARIFA = 0.15;

        //Mensaje
        System.out.println("Párking Morvedre");
        System.out.println("================");

        try {
            //Pedir al usuario hora y minuto de entrada
            System.out.print("Hora entrada .......: ");
            int hEntrada = SCN.nextInt();
            System.out.print("Minuto entrada .....: ");
            int mEntrada = SCN.nextInt();

            //separador
            System.out.println("---");

            //Mostrar en pantalla datos manuales
            System.out.printf("Momento entrada ....: %02d:%02dh - Manual %n", hEntrada, mEntrada);

            //Pasar datos recogidos a minutos            
            int mMin = hEntrada * 60 + mEntrada + 1;

            //Minutos aleatorios
            int mRnd = RND.nextInt(M_MAX - mMin + 1) + mMin;

            //Pasar datos aleatorios a hora y minutos.
            int hSalida = mRnd / 60;
            int mSalida = mRnd % 60;

            //Mostrar por pantalla datos aleatorios
            System.out.printf("Momento salida .....: %02d:%02dh - Aleatorio%n", hSalida, mSalida);

            //Calcular los minutos de estacionamiento
            int tEstac = mRnd - mMin;

            //Pasar minutos de estacionamiento a horas y minutos
            int mEstac = tEstac % 60;
            int hEstac = tEstac / 60;

            //Calcular importe final según el tiempo de estacionamiento
            double importeFinal = tEstac * TARIFA;

            //separador
            System.out.println("---");

            //Mostrar en pantalla LA TARIFA, el TIEMPO DE ESTACIONAMIENTO y el IMPORTE FINAL
            System.out.printf(Locale.ENGLISH, "Tarifa .............: %.2f €/min" + "%n", TARIFA);
            System.out.printf("Tiempo facturado ...: %d minutos (%dh + %dm)%n", tEstac, hEstac, mEstac);
            System.out.printf(Locale.ENGLISH, "Importe ............: %.2f €%n", importeFinal);

        } catch (Exception e) {

            System.out.println("Error: Entrada incorrecta");

        } finally {

            SCN.nextLine();
        }

    }//main

}//class
