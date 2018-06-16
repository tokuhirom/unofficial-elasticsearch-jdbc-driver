package me.geso.elasticsearch.unofficial.jdbc.driver;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class UESDriverTest {
    @Test
    public void connect() throws Exception {
        DriverManager.registerDriver(new UESDriver());

        Connection connection = DriverManager.getConnection("jdbc:ues:localhost:9200");
        assertNotNull(connection);
    }

}
