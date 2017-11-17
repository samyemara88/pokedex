package com.example.selim.pokedex.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.selim.pokedex.R;
import com.example.selim.pokedex.module.CleanActivityView;
import com.example.selim.pokedex.module.CleanModule;
import com.example.selim.pokedex.presenter.MyPresenter;
import com.example.selim.pokedex.viewmodel.PokemonViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by selim on 17/11/2017.
 */

class CleanActivityViewImpl extends AppCompatActivity implements CleanActivityView {

    @Inject
    MyPresenter presenter;

    @BindView(R.id.PokemonNameTextView)
    TextView PokemonNameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder()
                .build()
                .plus(new CleanModule(this))
                .inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.load(1);
    }

    @Override
    public void displayPokemonName(PokemonViewModel viewModel){
        PokemonNameTextView.setText(viewModel.getName());
    }

    @Override
    public void displayPokemonNotFound(){}



}
