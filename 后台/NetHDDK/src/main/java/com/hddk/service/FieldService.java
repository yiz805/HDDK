package com.hddk.service;

import com.hddk.entity.Field;

import java.util.List;

public interface FieldService {
    void newField(Field field);

    List<Field> getFieldByA_id(int a_id);

    void deleteFiled(int f_id);

    void updateField(Field field);
}
