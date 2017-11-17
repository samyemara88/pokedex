package com.example.selim.pokedex.presenter;

import com.example.selim.pokedex.MyInteractor;
import com.example.selim.pokedex.Pokemon;
import com.example.selim.pokedex.exception.PokemonRepositoryException;
import com.example.selim.pokedex.viewmodel.PokemonViewModel;

/**
 * Created by selim on 17/11/2017.
 */

class MyPresenterImpl implements MyPresenter {

    private final CleanActivity view;
    private final MyInteractor interactor;

    MyPresenterImpl(CleanActivity view, MyInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void load(int id){
        try {
            Pokemon pokemon = interactor.getAllPokemon();
            PokemonViewModel viewModel = new PokemonViewModel(pokemon.getName(),pokemon.getId());
        } catch (PokemonRepositoryException e) {
            view.displayPokemonNotFound;
        }

    }
}
