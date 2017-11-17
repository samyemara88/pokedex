package com.example.selim.pokedex.viewmodel;

/**
 * Created by selim on 17/11/2017.
 */

public class PokemonViewModel {
    private final String name;
    private final int weight;
    private final int height;

    public PokemonViewModel(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getName(){return name;}
    public int getWeight(){return weight;}
    public int getHeight() {return height;}
}
