package com.company.personas;

// Importamos clases e interfaces que nos van a ayudar a resolver el problema
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// Creamos la clase Persona
public class Persona {

    // Creamos las variables de clase Nombre y Apellido como private
    private String Nombre;
    private String Apellido;

    // Constructor sin argumentos
    public Persona() {}

    // Constructor con argumentos
    public Persona(String nombre, String apellido) {
        Nombre = nombre;
        Apellido = apellido;
    }

    // Getters y Setters para las variables private
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    // Sobreescribimos el método toString() para que sea más amigable su resultado
    @Override
    public String toString() {
        return "{ " + "Nombre: " + Nombre + ", " + "Apellido: " + Apellido + " }";
    }

    // Método para ordenar la lista por Nombre
    public static void ordenarPorNombre(List<Persona> personasArray) {

        // Se ordena la lista pasada como argumento
        Collections.sort(personasArray, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });

        // Se muestran los resultados ordenados en consola
        System.out.println("\nLa lista ordenada por Nombre es: ");
        for(Persona persona : personasArray){
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }
    };

    // Método para ordenar la lista por Apellido
    public static void ordenarPorApellido(List<Persona> personasArray) {

        // Se ordena la lista pasada como argumento
        Collections.sort(personasArray, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getApellido().compareTo(o2.getApellido());
            }
        });

        // Se muestran los resultados ordenados en consola
        System.out.println("\nLa lista ordenada por Apellido es: ");
        for(Persona persona : personasArray){
            System.out.println(persona.getApellido() + ", " + persona.getNombre());
        }
    };

    // Método para ordenar la lista por Apellido inversamente
    public static void ordenarPorApellidoInversamente(List<Persona> personasArray) {

        // Se ordena la lista pasada como argumento
        Collections.sort(personasArray, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getApellido().compareTo(o1.getApellido());
            }
        });

        // Se muestran los resultados ordenados en consola
        System.out.println("\nLa lista ordenada por Apellido inversamente es: ");
        for(Persona persona : personasArray){
            System.out.println(persona.getApellido() + ", " + persona.getNombre());
        }
    };

    // Override de método equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(Nombre, persona.Nombre) && Objects.equals(Apellido, persona.Apellido);
    }

    // Override de método hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Apellido);
    }
}
