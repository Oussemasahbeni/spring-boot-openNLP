package com.nour.springnlpdemo.nlpService;

public class TableData {
    String tableName;
    String label;
    String idColumnName;
    String[] columnNames;

    TableData(String tableName, String label, String idColumnName, String[] columnNames) {
        this.tableName = tableName;
        this.label = label;
        this.idColumnName = idColumnName;
        this.columnNames = columnNames;
    }

    public TableData(String label, String id) {
        this.label = label;
        this.idColumnName = id;
    }

    public String getLabel() {
        return label;
    }

    public String getId() {
        return idColumnName;
    }

}
