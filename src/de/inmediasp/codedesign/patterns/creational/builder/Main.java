package de.inmediasp.codedesign.patterns.creational.builder;

import de.inmediasp.codedesign.patterns.creational.builder.House.HouseBuilder;

public class Main {

    public static void main(String[] args){
        HouseBuilder builder = new HouseBuilder();
        House house = builder
                .room("Living Room")
                .room("Sleeping Room")
                .kitchen()
                .bathroom()
                .roof()
                .garage()
                .window().window()
                .build();
        System.out.println(house);
    }
}
