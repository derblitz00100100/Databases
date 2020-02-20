package com.mistershorr.databases;

public class Friend {

    private double gymFrequency;
    private boolean isAwesome;
    private double moneyOwed;
    private String name;
    private int trustworthiness;

    public Friend() {

    }

    private int clumsiness;

    public int getClumsiness() {
        return clumsiness;
    }

    public void setClumsiness(int clumsiness) {
        this.clumsiness = clumsiness;
    }

    public double getGymFrequency() {
        return gymFrequency;
    }

    public void setGymFrequency(double gymFrequency) {
        this.gymFrequency = gymFrequency;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public double getMoneyOwed() {
        return moneyOwed;
    }

    public void setMoneyOwed(double moneyOwed) {
        this.moneyOwed = moneyOwed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrustworthiness() {
        return trustworthiness;
    }

    public void setTrustworthiness(int trustworthiness) {
        this.trustworthiness = trustworthiness;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "gymFrequency=" + gymFrequency +
                ", isAwesome=" + isAwesome +
                ", moneyOwed=" + moneyOwed +
                ", name='" + name + '\'' +
                ", trustworthiness=" + trustworthiness +
                ", clumsiness=" + clumsiness +
                '}';
    }
}
