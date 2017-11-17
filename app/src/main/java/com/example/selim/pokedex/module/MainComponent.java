package com.example.selim.pokedex.module;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by selim on 17/11/2017.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    CleanComponent plus(CleanModule module);
}
