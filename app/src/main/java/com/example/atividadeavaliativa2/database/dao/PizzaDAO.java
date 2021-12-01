package com.example.atividadeavaliativa2.database.dao;

import com.example.atividadeavaliativa2.entity.Pizza;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PizzaDAO {

        @Insert
        void salvar(Pizza pizza);

        @Query("SELECT * FROM Pizza")
        List<Pizza> getPizzas();

        @Delete
        void excluir(Pizza pizza);


        @Update
        void editar(Pizza pizza);
}
