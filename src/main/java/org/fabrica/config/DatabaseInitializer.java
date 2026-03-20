package org.fabrica.config;

import java.sql.Connection;
import java.sql.Statement;


public class DatabaseInitializer {

    public static void init() {

        String sql = "CREATE TABLE IF NOT EXISTS produto (\n"
                + "    id INT AUTO_INCREMENT PRIMARY KEY,\n"
                + "    nome VARCHAR(100),\n"
                + "    tipo VARCHAR(50)\n,"
                + "cor  VARCHAR(50) NULL\n"
                + ")";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

