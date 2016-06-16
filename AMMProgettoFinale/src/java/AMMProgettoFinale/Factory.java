/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Factory {

    private static Factory singleton;
    String connectionString;

    public static Factory getInstance() {
        if (singleton == null) {
            singleton = new Factory();
        }
        return singleton;
    }

    private Factory() {

    }
}
