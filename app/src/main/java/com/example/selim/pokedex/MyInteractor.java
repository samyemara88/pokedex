package com.example.selim.pokedex;

import com.example.selim.pokedex.exception.PokemonRepositoryException;
import com.example.selim.pokedex.repository.MyRepository;

/**
 * Created by selim on 17/11/2017.
 */

public class MyInteractor {
    private final MyRepository repository;

    public MyInteractor(MyRepository repository) {
        this.repository = repository;
    }

    public Pokemon getPokemonById(int id) throws PokemonRepositoryException{
        return repository.getPokemonById(id);
    }

    public Pokemon getAllPokemon() throws PokemonRepositoryException{
        return repository.getAllPokemon();
    }
}
