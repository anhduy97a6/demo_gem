package application.data.serviceImpl;

import application.data.model.AttributesValue;
import application.data.repository.AttributesValueRepository;
import application.data.service.AttributesValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributesValueServiceImpl implements AttributesValueService {
    @Autowired
    AttributesValueRepository attributesValueRepository;

    @Override
    public void save(AttributesValue attributesValue) {
        attributesValueRepository.save(attributesValue);
    }

    @Override
    public void saveList(List<AttributesValue> attributesValues) {
        attributesValueRepository.save(attributesValues);
    }
}
