package com.example;
import java.util.Scanner;  // Import the Scanner class
public class Mes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingresar mes: ");

        String mesIngresado = sc.nextLine();  // Read user input
        System.out.println("El mes ingresado es: " + mesIngresado);  // Output user input
        sc.close();

        switch (mesIngresado.toLowerCase()) {
            case "enero":
                System.out.println("El número del mes es: 1");
                break;
            case "febrero":
                System.out.println("El número del mes es: 2");
                break;
            case "marzo":
                System.out.println("El número del mes es: 3");
                break;
            case "abril":
                System.out.println("El número del mes es: 4");
                break;
            case "mayo":
                System.out.println("El número del mes es: 5");
                break;
            case "junio":
                System.out.println("El número del mes es: 6");
                break;
            case "julio":
                System.out.println("El número del mes es: 7");
                break;
            case "agosto":
                System.out.println("El número del mes es: 8");
                break;
            case "septiembre":
                System.out.println("El número del mes es: 9");
                break;
            case "octubre":
                System.out.println("El número del mes es: 10");
                break;
            case "noviembre":
                System.out.println("El número del mes es: 11");
                break;
            case "diciembre":
                System.out.println("El número del mes es: 12");
                break;
            default:
                System.out.println("El mes ingresado es incorrecto");
        }
    }
}
