package application.controller.api;

import application.data.model.Attributes;
import application.data.model.AttributesValue;
import application.data.service.AttributesService;
import application.data.service.AttributesValueService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.AttributesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attributes")
public class AttributesApiController {
    @Autowired
    AttributesService attributesService;
    @Autowired
    AttributesValueService attributesValueService;

    @GetMapping("/delete/{id}")
    public BaseApiResult deleteAttributes(@PathVariable int id) {
        BaseApiResult result = new BaseApiResult();

        try {
            attributesService.deleteAttributes(id);
            result.setSuccess(true);
            result.setMessage("Delete Success");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @PostMapping("/add")
    public DataApiResult addAttributes(@RequestBody Attributes attributes) {
        DataApiResult result = new DataApiResult();
        if (attributesService.saveAttributes(attributes)) {

            result.setMessage("Success Supfulyy");
            result.setSuccess(true);
            result.setData(attributes.getId());
        }
        else {
            result.setSuccess(false);
            result.setMessage("False");
        }
        return result;
    }
}
