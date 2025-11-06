package com.core.mongo.coreEx.util;


import com.core.mongo.entity.Emp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DBUtil {

    private static Connection con = null;

    public static Connection getConnection() {
        if(con == null) {
            try {

                //Class.forName("mongodb.jdbc.MongoDriver");
                Class.forName("");
                con = DriverManager.getConnection("mongodb://localhost:27017/employee");
                System.out.println("Connection created....");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static List<Emp> readEmployeeJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return  objectMapper.readValue(new File(filePath), new TypeReference<List<Emp>>() {});
    }








}
