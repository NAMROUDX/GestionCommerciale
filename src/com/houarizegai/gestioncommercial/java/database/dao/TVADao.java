package com.houarizegai.gestioncommercial.java.database.dao;

import com.houarizegai.gestioncommercial.java.database.DBConnection;
import com.houarizegai.gestioncommercial.java.database.models.Client;
import com.houarizegai.gestioncommercial.java.database.models.designpatterns.builder.ClientBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class TVADao {
    public static List<Double> getTauxTva() { // This function get all taux tva from table TVA in database
        //TauxTva
        String sql = "SELECT * FROM TVA;";

        List<Double> tauxTva = new LinkedList<>();
        try {
            Statement st = DBConnection.con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tauxTva.add(rs.getDouble("TauxTva"));
            }

        } catch (SQLException se) {
            System.out.println("Get All taux TVA Error SQL");
            se.printStackTrace();
            return null;
        }

        return tauxTva;

    }
}
