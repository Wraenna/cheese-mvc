package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // getAll

    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    // add

    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    // remove

    public static void remove(int id) {
        Cheese cheeseToRemove = getByID(id);
        cheeses.remove(cheeseToRemove);
    }

    // edit

    public static void edit(int id, String name, String desc, CheeseType type, int rating) {
        Cheese cheeseToEdit = getByID(id);
        cheeseToEdit.setCheeseName(name);
        cheeseToEdit.setCheeseDesc(desc);
        cheeseToEdit.setCheeseType(type);
        cheeseToEdit.setCheeseRating(rating);
    }

    // getByID

    public static Cheese getByID(int id) {

        Cheese theCheese = null;

        for(Cheese candidateCheese : cheeses) {
            if(candidateCheese.getCheeseID() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }
}
