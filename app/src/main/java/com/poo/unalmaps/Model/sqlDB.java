package com.poo.unalmaps.Model;

import android.util.Log;
import android.view.View;

import com.poo.unalmaps.View.main.InfoTabFrag;

import java.sql.*;

public class sqlDB {

    public static void connectToDB() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/juanb/AndroidStudioProjects/UnalMaps/app/src/main/java/com/poo/unalmaps/Model/InfoEdificios.db";
            conn = DriverManager.getConnection(url);
            Log.d("DBCONN", "Connection to SQLite established");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(conn != null){
                    conn.close();
                }
            }
            catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
