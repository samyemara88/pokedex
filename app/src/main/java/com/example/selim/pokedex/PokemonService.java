package com.example.selim.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by selim on 17/11/2017.
 */

public interface PokemonService {

    @Headers({"Accept: application/json"})
    @GET("pokemon/{id}/")
    Call<Pokemon> getPokemonById(@Path("id") int id);

    @GET("pokemon/")
    Call<Pokemon> getAllPokemon();
}

