package com.pinicius.android.cas2016.main;

import com.karumi.rosie.repository.datasource.InMemoryCacheDataSource;
import com.karumi.rosie.time.TimeProvider;
import com.pinicius.android.cas2016.room.domain.model.Room;
import com.pinicius.android.cas2016.session.repository.datasource.cache.DayOneSessionsInMemoryCache;
import com.pinicius.android.cas2016.session.repository.datasource.cache.DayTwoSessionsInMemoryCache;
import com.pinicius.android.cas2016.speaker.domain.model.Speaker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * Created by pinicius on 28/11/16.
 */

@Module(library = true,
        complete = false,
        injects = {
                MainApplication.class
        }) public class ApplicationModule {

        private static final long IN_MEMORY_CACHE_TTL = MINUTES.toMillis(5);

        @Provides @Singleton
        public DayOneSessionsInMemoryCache provideDayOneSessionsInMemoryCache() {
                return new DayOneSessionsInMemoryCache(new TimeProvider(), IN_MEMORY_CACHE_TTL);
        }

        @Provides @Singleton
        public DayTwoSessionsInMemoryCache provideDayTwoSessionsInMemoryCache() {
                return new DayTwoSessionsInMemoryCache(new TimeProvider(), IN_MEMORY_CACHE_TTL);
        }

        @Provides @Singleton
        public InMemoryCacheDataSource<Integer, Speaker> provideSpeakersInMemoryCache() {
                return new InMemoryCacheDataSource<>(new TimeProvider(), IN_MEMORY_CACHE_TTL);
        }

        @Provides @Singleton
        public InMemoryCacheDataSource<Integer, Room> provideRoomsInMemoryCache() {
                return new InMemoryCacheDataSource<>(new TimeProvider(), IN_MEMORY_CACHE_TTL);
        }
}
