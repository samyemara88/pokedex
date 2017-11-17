package com.example.selim.pokedex.viewmodel;

/**
 * Created by selim on 17/11/2017.
 */

public class PokemonViewModel {
    private final String name;
    private final int id;

    public PokemonViewModel(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getName(){return name;}
    public int getId(){return id;}
}
