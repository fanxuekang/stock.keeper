package com.iss.server.dao;

import java.util.List;

public abstract class BaseDao<T> {
    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean remove(T t);
    public abstract List<T> query(T t);
}
