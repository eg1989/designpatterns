package de.inmediasp.codedesign.patterns.creational.builder;

import de.inmediasp.codedesign.patterns.creational.builder.model.*;

import java.util.LinkedList;

public class House{
    private LinkedList<Room> rooms;
    private Bathroom bathroom;
    private Kitchen kitchen;
    private LinkedList<Window> windows;
    private Garage garage;
    private Garden garden;
    private Roof roof;

    private House(){
        this.rooms = new LinkedList<>();
        this.windows = new LinkedList<>();
    }

    public House(LinkedList<Room> rooms, Bathroom bathroom, Kitchen kitchen, LinkedList<Window> windows, Garage garage, Garden garden, Roof roof) {
        this.rooms = rooms;
        this.bathroom = bathroom;
        this.kitchen = kitchen;
        this.windows = windows;
        this.garage = garage;
        this.garden = garden;
        this.roof = roof;
    }

    public boolean isValid(){
        return ( hasAtleastOneRoom()
                && ( hasBathroom() )
                && ( hasKitchen() )
                && ( hasRoof() )
                && ( hasAtleastOneWindow()) );
    }

    private boolean hasRoof(){
        return this.roof!=null;
    }

    private boolean hasKitchen(){
        return this.kitchen!=null;
    }

    private boolean hasBathroom(){
        return this.bathroom!=null;
    }

    private boolean hasGarage(){
        return this.garage!=null;
    }

    private boolean hasGarden(){
        return this.garden!=null;
    }

    private boolean hasAtleastOneWindow(){
        return this.windows.size()>=1;
    }

    private boolean hasAtleastOneRoom(){
        return this.rooms.size()>=1;
    }

    public String toString(){
        String s = new String();
        StringBuilder builder =  new StringBuilder();
        builder.append("This House contains:\n\t");
        builder.append(this.rooms.size()).append(" Rooms:\n\t\t");
        for(Room r: this.rooms){
            builder.append(r.getName());
            builder.append("\n\t");
            if(r!=this.rooms.getLast()){
                builder.append("\t");
            }
        }
        if(this.hasKitchen())
            builder.append("A Kitchen\n\t");
        if(this.hasBathroom())
            builder.append("A Bathroom\n\t");
        if(this.hasRoof())
            builder.append("A Roof\n\t");
        if(this.hasGarage())
            builder.append("A Garage\n\t");
        if(this.hasGarden())
            builder.append("A Garden\n\t");
        builder.append(this.windows.size()).append(" Windows");
        return builder.toString();
    }

    public static class HouseBuilder{

        private House house;

        public HouseBuilder(){
            this.house = new House();
        }

        public HouseBuilder room(String roomName){
            this.house.rooms.add(new Room(roomName));
            return this;
        }

        public HouseBuilder kitchen(){
            this.house.kitchen = new Kitchen();
            return this;
        }

        public HouseBuilder bathroom(){
            this.house.bathroom = new Bathroom();
            return this;
        }

        public HouseBuilder window(){
            this.house.windows.add(new Window());
            return this;
        }

        public HouseBuilder garage(){
            this.house.garage= new Garage();
            return this;
        }

        public HouseBuilder roof(){
            this.house.roof = new Roof();
            return this;
        }

        public House build(){
            return this.house;
        }

        public void clear(){
            this.house = new House();
        }
    }

}
