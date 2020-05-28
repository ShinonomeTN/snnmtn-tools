package com.shinonometn.commons.validator;

import java.util.List;
import java.util.Set;

public interface ValidationMeta {

    Set<String> getGroup();

    List<FieldValidator> getFields(String group);

    default List<FieldValidator> getFields(Class<?> beanClass) {
        return getFields(beanClass.getName());
    }
}
