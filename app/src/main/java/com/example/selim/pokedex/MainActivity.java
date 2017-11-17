package com.example.selim.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.selim.pokedex.module.CleanActivityView;
import com.example.selim.pokedex.viewmodel.PokemonViewModel;

public class MainActivity extends AppCompatActivity implements CleanActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void displayPokemonName(PokemonViewModel viewModel) {

    }

    @Override
    public void displayPokemonNotFound() {

    }
}
