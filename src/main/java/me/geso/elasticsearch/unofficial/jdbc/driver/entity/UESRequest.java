package me.geso.elasticsearch.unofficial.jdbc.driver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UESRequest {
    private final String query;

    public UESRequest(@JsonProperty("query") String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
