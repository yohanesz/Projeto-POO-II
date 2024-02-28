package com.yzanghelini.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static ConexaoDB instance;

    private Connection connection;

    private ConexaoDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetoTrello";
            this.connection = DriverManager.getConnection(url, "admin", "adminPassword");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver JDBC não encontrado.", e);
        }
    }

    public static synchronized ConexaoDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexaoDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeDataSource() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }
}
