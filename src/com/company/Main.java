package com.company;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public void printGuiones(char[] src) {
        for (int i = 0; i <= src.length - 1; i++) {

            System.out.print(src[i]);

        }
    }

    public String acentos(String acento) {

        acento = acento.replace('á', 'a');
        acento = acento.replace('é', 'e');
        acento = acento.replace('í', 'i');
        acento = acento.replace('ó', 'o');
        acento = acento.replace('ú', 'u');

        return acento;

    }



    public static void main(String[] args) throws IOException {

        Main ahorcado = new Main();

        Dibujo dibujo = new Dibujo();

        Scanner input = new Scanner(System.in);

        Random random = new Random();

        String[] respuestas = new String[80383];

        Files.readAllLines(Paths.get("palabras.txt")).toArray(respuestas);

        String respuesta = respuestas[random.nextInt(80383)];

        respuesta = respuesta.toLowerCase();
        respuesta = ahorcado.acentos(respuesta);


        char[] letras = respuesta.toCharArray();

        char[] guiones = new char[letras.length];

        for (int i = 0; i <= letras.length - 1; i++) {

            guiones[i] = '-';

        }

        ahorcado.printGuiones(guiones);


        for (int i = 0; i < 7; i++) {

            boolean acierto = false;
            System.out.println();

            System.out.println("Dime una letra: ");
            char letra = input.next().charAt(0);

            for (int j = 0; j <= letras.length - 1; j++) {

                if (letra == letras[j]) {

                    guiones[j] = letra;
                    acierto = true;

                }

            }

            if (acierto) {

                System.out.println("Has acertado");

                if (i < 7) {

                    i--;

                }

            } else {

                dibujo.dibujar(7 - i - 1);

                System.out.println("Has fallado. Te quedan " + (7 - i - 1) + " intentos.");
            }

            ahorcado.printGuiones(guiones);

            if (i == 6) {
                System.out.println("La palabra es : " + respuesta);
            }

        }

    }

}
