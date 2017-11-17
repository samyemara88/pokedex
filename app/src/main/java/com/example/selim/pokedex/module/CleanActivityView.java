package com.example.selim.pokedex.module;

import com.example.selim.pokedex.viewmodel.PokemonViewModel;

/**
 * Created by selim on 17/11/2017.
 */

public interface CleanActivityView {
    void displayPokemonName(PokemonViewModel viewModel);
    void displayPokemonNotFound();
}
