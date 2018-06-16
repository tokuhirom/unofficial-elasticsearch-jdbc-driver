package me.geso.elasticsearch.unofficial.jdbc.driver;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class UESResultSetTest {
    @Test
    public void findColumn() throws SQLException {
        DriverManager.registerDriver(new UESDriver());

        Connection connection = DriverManager.getConnection("jdbc:ues:localhost:9200");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library WHERE release_date < '2000-01-01' order by name");
        ResultSet resultSet = preparedStatement.executeQuery();
        assertEquals(1, resultSet.findColumn("author"));
        assertEquals(2, resultSet.findColumn("name"));
        assertEquals(3, resultSet.findColumn("page_count"));
        assertEquals(4, resultSet.findColumn("release_date"));
    }

    @Test
    public void getString() throws SQLException {
        DriverManager.registerDriver(new UESDriver());

        Connection connection = DriverManager.getConnection("jdbc:ues:localhost:9200");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library WHERE release_date < '2000-01-01' order by name");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> columns = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            columns.add(name);
        }
        assertEquals("Dune,Hyperion", columns.stream().collect(Collectors.joining(",")));
    }
}
