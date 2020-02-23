package com.iss.server.util;

import java.sql.ResultSet;
import java.util.List;

public interface Entityable<T> {
    List<T> convertToEntity(ResultSet resultSet);
}
