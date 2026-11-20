package main.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
        System.getenv("SIGMA_DB_URL"),
        System.getenv("SIGMA_DB_USER"),
        System.getenv("SIGMA_DB_PASSWORD")
        );
    }
}