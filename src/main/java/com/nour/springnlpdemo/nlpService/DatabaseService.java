package com.nour.springnlpdemo.nlpService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;


@Service
public class DatabaseService {


    @Value("${database.url}")
    private String url;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    public Map<String, TableData> fetchData() throws Exception {
        // Create a map to store the fetched data and their labels
        Map<String, TableData> data = new HashMap<>();

        // Establish a connection to the database
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Define a list of tables and their corresponding columns
            List<TableData> tables = Arrays.asList(
                    new TableData("configuration_service.skill", "skill", "id", new String[]{"name"}),
                    new TableData("configuration_service.contract_type", "contract_type", "id", new String[]{"name_en", "name_fr"}),
                    new TableData("configuration_service.job_category", "job_category", "id", new String[]{"name_en", "name_fr"}),
                    new TableData("configuration_service.job_title", "job_title", "id", new String[]{"name_en", "name_fr"}),
                    new TableData("configuration_service.industry", "industry", "id", new String[]{"name_en", "name_fr"})
            );

            // Fetch data from each table
            for (TableData table : tables) {
                fetchDataFromTable(stmt, "SELECT * FROM " + table.tableName, table.label, data, table.idColumnName, table.columnNames);
            }
        }

        // Return the map of data and their labels
        return data;
    }

    private void fetchDataFromTable(Statement stmt, String query, String label, Map<String, TableData> data, String idColumnName, String... columnNames) throws SQLException {
        try (ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String id = rs.getString(idColumnName);
                for (String columnName : columnNames) {
                    // Get the data from the current row
                    String dataValue = rs.getString(columnName);
                    // Add the data and their labels to the map
                    data.put(dataValue, new TableData(label, id));
                }
            }
        }
    }


}