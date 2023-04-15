package com.example.numeroflotante;

public class NumeroFlotante {
    public static void main(String[] args) {
        // Almacenamos el número flotante en una variable tipo float
        float numeroFlotante = 4.5f;

        // Extraemos la parte entera de la variable numeroFlotante
        int parteEntera = (int) numeroFlotante;

        // Extraemos la parte decimal de la variable numeroFlotante
        float parteDecimal = numeroFlotante - parteEntera;

        // VERIFICACIÓN DE RESULTADOS

        // Verificamos el número float ingresado
        System.out.println("El número float es: " + numeroFlotante);

        // Verificamos la parte entera del número float ingresado
        System.out.println("La parte entera del número float es: " + parteEntera);

        // Verificamos la parte decimal del número float ingresado
        System.out.println("La parte decimal del número float es: " + parteDecimal);
    }
}
