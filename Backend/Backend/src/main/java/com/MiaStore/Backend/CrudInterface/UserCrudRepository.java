package com.MiaStore.Backend.CrudInterface;

import com.MiaStore.Backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User,Integer>{
    //consultas en mongodb @Query
    @Query("{email:?0}")
    Optional<User> findByEmail(String email);
    @Query("{email:?0, password:?1}") //Consulta mongodb = {primera_variable:?posicion_0_en_funcion, segunda_variable:?posicion_1_en_funcion}
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc(); //encontrar por el id mas alto en orden desendente -> encuentra el id mayor

    @Query("{'monthBirthtDay': { $eq:?0}}")
    List<User> findByBirthdayMonth(String month);
}
