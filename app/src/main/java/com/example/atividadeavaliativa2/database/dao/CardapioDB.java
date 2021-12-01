package com.example.atividadeavaliativa2.database.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.atividadeavaliativa2.entity.Pizza;

@Database(entities = {Pizza.class}, version = 1, exportSchema = false)
public abstract class CardapioDB extends RoomDatabase {

    private static final String DB_NAME = "cardapio";

    public abstract PizzaDAO getPizzaDAO();

    private static CardapioDB instance;

    public static CardapioDB getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context, CardapioDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
