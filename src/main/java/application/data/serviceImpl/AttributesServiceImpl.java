package application.data.serviceImpl;

import application.data.model.Attributes;
import application.data.repository.AttributesRepository;
import application.data.service.AttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributesServiceImpl implements AttributesService {
    @Autowired
    AttributesRepository attributesRepository;

    @Override
    public List<Attributes> findAll() {
        return attributesRepository.findAll();
    }

    @Override
    public boolean deleteAttributes(int id) {
        try {
            attributesRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean saveAttributes(Attributes attributes) {
        try {
            attributesRepository.save(attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
