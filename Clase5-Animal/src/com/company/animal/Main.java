package com.company.animal;

public class Main {
    public static void main(String[] args) {
        Gato michi = new Gato();
        michi.setCantidadDePatas(4);
        michi.setAmistoso(true);
        michi.setAlimentoPreferido("Gati");

        System.out.println("Mi gato tiene " + michi.getCantidadDePatas() + " patas");
        System.out.println("Mi gato es amistoso: " + michi.isAmistoso());
        System.out.println("El alimento preferido de mi gato es: " + michi.getAlimentoPreferido());
    }
}
