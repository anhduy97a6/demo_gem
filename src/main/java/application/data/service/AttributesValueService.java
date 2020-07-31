package application.data.service;

import application.data.model.AttributesValue;

import java.util.List;

public interface AttributesValueService {
    void save(AttributesValue attributesValue);
    void saveList(List<AttributesValue> attributesValues);
}
