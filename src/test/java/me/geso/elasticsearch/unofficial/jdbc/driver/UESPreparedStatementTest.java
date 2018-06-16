package me.geso.elasticsearch.unofficial.jdbc.driver;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class UESPreparedStatementTest {
    @Test
    public void executeQuery() throws Exception {
        DriverManager.registerDriver(new UESDriver());

        Connection connection = DriverManager.getConnection("jdbc:ues:localhost:9200");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library WHERE release_date < '2000-01-01'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        assertNotNull(connection);
    }
}
