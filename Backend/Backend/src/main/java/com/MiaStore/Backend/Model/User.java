package com.MiaStore.Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * Crear una coleccion en mongo db
 */

@Data
@RequiredArgsConstructor
/*@NoArgsConstructor*/
@AllArgsConstructor
@Document(collection= "user") //Como vamos a nombrar nuestra tabla (Base de datos)
public class User implements Serializable {
    @Id
    private Integer id;

    @Field(name="identification")
    private String identification;

    @Field(name="name")
    private String name;

    @Field(name="Birth_Day")
    private Date birthtDay;

    @Field(name="Month_Birth_Day")
    private String monthBirthtDay;

    @Field(name="address")
    private String address;

    @Field(name="cellphone")
    private String cellPhone;

    @Field(name="email")
    private  String email;

    @Field(name="password")
    private String password;

    @Field(name="zone")
    private String zone;

    @Field(name = "type")
    private String type;

}

