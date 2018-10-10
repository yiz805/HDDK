package com.hddk.service.impl;

import com.hddk.entity.Field;
import com.hddk.mapper.FieldMapper;
import com.hddk.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldMapper fieldMapper;

    public void newField(Field field) {
        fieldMapper.newField(field);
    }

    public List<Field> getFieldByA_id(int a_id) {
        return fieldMapper.getFieldByA_id(a_id);
    }

    public void deleteFiled(int f_id) {
        fieldMapper.deleteFiled(f_id);
    }

    public void updateField(Field field) {
        fieldMapper.updateField(field);
    }

    public Field getFieldByF_id(int f_id) {
        return fieldMapper.getFieldByF_id(f_id);
    }
}
