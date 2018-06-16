package me.geso.elasticsearch.unofficial.jdbc.driver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class UESResponse {
    private final List<UESColumn> columns;
    private final List<List<String>> rows;

    public UESResponse(@JsonProperty("columns") List<UESColumn> columns, @JsonProperty("rows") List<List<String>> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public List<UESColumn> getColumns() {
        return columns;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UESResponse that = (UESResponse) o;
        return Objects.equals(columns, that.columns) &&
                Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns, rows);
    }

    @Override
    public String toString() {
        return "UESResponse{" +
                "columns=" + columns +
                ", rows=" + rows +
                '}';
    }

    public static class UESColumn {
        private final String name;
        private final String type;

        public UESColumn(@JsonProperty("name") String name, @JsonProperty("type") String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UESColumn uesColumn = (UESColumn) o;
            return Objects.equals(name, uesColumn.name) &&
                    Objects.equals(type, uesColumn.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, type);
        }

        @Override
        public String toString() {
            return "UESColumn{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
