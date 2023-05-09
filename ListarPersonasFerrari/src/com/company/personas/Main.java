package com.company.personas;

// Importamos clases que nos van a ayudar a resolver el problema
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creamos las 5 personas como nuevas instancias de la clase Persona
        Persona persona1 = new Persona("Franco", "Ferrari");
        Persona persona2 = new Persona("Charles", "Leclerc");
        Persona persona3 = new Persona("Carlos", "Sainz");
        Persona persona4 = new Persona("Valtteri", "Bottas");
        Persona persona5 = new Persona("Guanyu", "Zhou");

        // Creamos el ArrayList para guardar las 5 personas creadas anteriormente
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        // Agregamos las 5 personas al ArrayList listaPersonas
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);

        // Llamado a la función ordenar por Nombre
        Persona.ordenarPorNombre(listaPersonas);

        // Llamado a la función ordenar por Apellido
        Persona.ordenarPorApellido(listaPersonas);

        // Llamado a la función ordenar por Apellido inversamente
        Persona.ordenarPorApellidoInversamente(listaPersonas);
    }
}
