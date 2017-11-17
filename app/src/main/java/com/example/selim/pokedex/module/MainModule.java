package com.example.selim.pokedex.module;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import android.os.Handler;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by selim on 17/11/2017.
 */
@Module
public class MainModule {

    static final String MAIN_THREAD = "mainThread";
    static final String BACKGROUND_THREAD = "backgroundThread";

    @Provides
    @Singleton
    @Named(BACKGROUND_THREAD)
    Executor providesBackgroundExecutor(){return Executors.newSingleThreadExecutor();}

    @Provides
    @Singleton
    @Named(MAIN_THREAD)
    Executor provideMainExecutor(){return new HandlerExecutor(new Handler(Looper.getMainLooper()));}

    class HandlerExecutor implements Executor{
        private Handler handler;

        HandlerExecutor(Handler handler){
            this.handler = handler;
        }

        @Override
        public void execute(@NonNull final Runnable runnable) {
            handler.post(new Runnable(){

                @Override
                public void run() {
                    runnable.run();

                }
            });

        }
    }
}
