package com.iss.client.view.Component;

import java.util.List;

public abstract class DataTable<T> {
    private List<T> dataSource;

    public abstract void initTable();

    public abstract void initTable(List<T> dataSource);

    public void setDataSource(List<T> dataSource) {
        this.dataSource = dataSource;
    }

}