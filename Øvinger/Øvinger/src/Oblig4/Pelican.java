package Oblig4;

public class Pelican extends Oviparous implements Flyable, Walkable {

    public Pelican(String name, int code) {
        super(name, code);
    }

    public boolean fly(){
        return true;
    }

    public boolean walk(){
        return true;
    }
}
