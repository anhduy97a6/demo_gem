package application.data.service;

import application.data.model.Attributes;

import java.util.List;

public interface AttributesService {
    List<Attributes> findAll();
    boolean deleteAttributes(int id);
    boolean saveAttributes(Attributes attributes);

}
