package org.launchcode.cheesemvc.models;

public class Cheese {

    private String cheeseName;
    private String cheeseDesc;

    private int cheeseID;
    private static int nextID = 1;

    public Cheese (String cheeseName, String cheeseDesc) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseDesc = cheeseDesc;
    }

    public Cheese () {
        cheeseID = nextID;
        nextID++;
    }

    public Cheese (String cheeseName) {
        this(cheeseName, "");
    }

    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String givenCheeseName) {
        cheeseName = givenCheeseName;
    }

    public String getCheeseDesc() {
        return cheeseDesc;
    }

    public void setCheeseDesc(String givenCheeseDesc) {
        cheeseDesc = givenCheeseDesc;
    }
}
