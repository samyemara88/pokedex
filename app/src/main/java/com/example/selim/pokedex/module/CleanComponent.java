package com.example.selim.pokedex.module;

import dagger.Subcomponent;

/**
 * Created by selim on 17/11/2017.
 */
@Subcomponent(modules = CleanModule.class)
public interface CleanComponent {
    void inject(CleanActivityView activity);
}
