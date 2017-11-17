package com.example.selim.pokedex.presenter;

import com.example.selim.pokedex.MyInteractor;
import com.example.selim.pokedex.Pokemon;
import com.example.selim.pokedex.exception.PokemonRepositoryException;
import com.example.selim.pokedex.module.CleanActivityView;
import com.example.selim.pokedex.viewmodel.PokemonViewModel;

/**
 * Created by selim on 17/11/2017.
 */

public class MyPresenterImpl implements MyPresenter {

    private final CleanActivityView view;
    private final MyInteractor interactor;

    public MyPresenterImpl(CleanActivityView view, MyInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void load(int id){
        try {
            Pokemon pokemonList = interactor.getAllPokemon();
            PokemonViewModel viewModel = new PokemonViewModel(pokemonList.getName(),pokemonList.getId());
        } catch (PokemonRepositoryException e) {
            view.displayPokemonNotFound();
        }

    }
}
