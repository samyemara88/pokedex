package com.example.selim.pokedex.repository;

import com.example.selim.pokedex.Pokemon;
import com.example.selim.pokedex.exception.PokemonRepositoryException;

/**
 * Created by selim on 17/11/2017.
 */

public interface MyRepository {
    Pokemon getPokemonById(int id) throws PokemonRepositoryException;

    Pokemon getAllPokemon() throws PokemonRepositoryException;
}
