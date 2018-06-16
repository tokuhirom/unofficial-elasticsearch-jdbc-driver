package me.geso.elasticsearch.unofficial.jdbc.driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class UESDriver implements java.sql.Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return new UESConnection(url, info);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith("jdbc:ues:");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
