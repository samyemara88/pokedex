package com.example.selim.pokedex.module;

import com.example.selim.pokedex.MyInteractor;
import com.example.selim.pokedex.presenter.MyPresenter;
import com.example.selim.pokedex.presenter.MyPresenterImpl;
import com.example.selim.pokedex.repository.MyRepository;
import com.example.selim.pokedex.repository.MyRepositoryImpl;
import com.example.selim.pokedex.viewmodel.PokemonViewModel;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by selim on 17/11/2017.
 */
@Module
public class CleanModule {

    private final CleanActivityView view;

    public CleanModule(CleanActivityView view) {
        this.view = view;
    }

    @Provides
    MyPresenter provideMyPresenter(
            @Named(MainModule.BACKGROUND_THREAD) Executor executor,
            CleanActivityView view,
            MyInteractor interactor
    ) {
        return new MyPresenterDecorator(executor, new MyPresenterImpl(view, interactor));
    }

    @Provides
    CleanActivityView provideCleabActivityView(
            @Named(MainModule.MAIN_THREAD) Executor executor
    ) {
        return new CleanViewDecorator(executor, view);
    }

    @Provides
    MyInteractor provideMyInteractor(MyRepository repository) {
        return new MyInteractor(repository);
    }

    @Provides
    MyRepository provideMyRepository() {
        return new MyRepositoryImpl();
    }

    class MyPresenterDecorator implements MyPresenter {
        private Executor executor;
        private MyPresenter presenter;

        MyPresenterDecorator(Executor executor, MyPresenter presenter) {
            this.executor = executor;
            this.presenter = presenter;
        }

        @Override
        public void load(final int id) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    presenter.load(id);
                }
            });
        }

    }

    class CleanViewDecorator implements CleanActivityView {
        private Executor executor;
        private CleanActivityView view;

        CleanViewDecorator(Executor executor, CleanActivityView view) {
            this.executor = executor;
            this.view = view;
        }

        @Override
        public void displayPokemonName(final PokemonViewModel viewModel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayPokemonName(viewModel);
                }
            });
        }

        @Override
        public void displayPokemonNotFound() {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayPokemonNotFound();
                }
            });
        }
    }
}
