package com.example.selim.pokedex.repository;

import com.example.selim.pokedex.Pokemon;
import com.example.selim.pokedex.PokemonService;
import com.example.selim.pokedex.exception.PokemonRepositoryException;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by selim on 17/11/2017.
 */

public class MyRepositoryImpl implements MyRepository {

    private static final String BASE_URL = "http://pokeapi.co/api/v2/";

    @Override
    public Pokemon getPokemonById(int id) throws PokemonRepositoryException{

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        PokemonService service = retrofit.create(PokemonService.class);
        try {
            Pokemon pokemon = service.getPokemonById(id).execute().body();
            return pokemon;
        } catch (IOException e) {
            throw new PokemonRepositoryException(e);
        }

    }

    @Override
    public Pokemon getAllPokemon() throws PokemonRepositoryException {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        PokemonService service = retrofit.create(PokemonService.class);
        try {
            Pokemon pokemonList = service.getAllPokemon().execute().body();
            return pokemonList;
        } catch (IOException e) {
            throw new PokemonRepositoryException(e);
        }
    }
}
