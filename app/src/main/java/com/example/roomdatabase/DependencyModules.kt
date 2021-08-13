package com.example.roomdatabase

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

//object DependencyModules {
//
//    val appModules = module {
//
//        factory { NoteDatabase.getDatabase( get()) }
//        viewModel { NoteViewModel( get()) }
//
//    }
//}

val dbModule = module {
    fun provideDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(application, NoteDatabase::class.java, "note_table")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: NoteDatabase): NoteDao {
        return database.getNoteDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }

}

val viewModelModule = module {
    viewModel { NoteViewModel(get()) }

}

val repositoryModule = module {
    fun provideUserRepository(dao: NoteDao): NoteRepository {
        return NoteRepository(dao)
    }
    single { provideUserRepository(get()) }
}