package com.farid.goaltp;

public class UnGoal {
    String nom;
    String exercice;
    String memonic;

    public UnGoal(String nom, String exercice, String memonic) {
        this.nom = nom;
        this.exercice = exercice;
        this.memonic = memonic;
    }

    public String getNom() {
        return nom;
    }

    public String getExercice() {
        return exercice;
    }

    public String getMemonic() {
        return memonic;
    }
}
