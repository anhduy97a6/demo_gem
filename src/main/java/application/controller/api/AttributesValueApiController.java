package application.controller.api;

import application.data.model.Attributes;
import application.data.model.AttributesValue;
import application.data.model.Solution;
import application.data.service.AttributesValueService;
import application.data.service.SolutionService;
import application.model.api.BaseApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attributesvalue")
public class AttributesValueApiController {

    @Autowired
    AttributesValueService attributesValueService;
    @Autowired
    SolutionService solutionService;

    @PostMapping("/add")
    public BaseApiResult newAttributesValue(@RequestBody Attributes attributes) {
        BaseApiResult result = new BaseApiResult();

        try {
            List<AttributesValue> attributesValueList = new ArrayList<>();
            List<Solution> solutionList = solutionService.findALl();
            for (Solution solution : solutionList) {
                AttributesValue attributesValue = new AttributesValue();
                attributesValue.setSolution(solution);
                attributesValue.setAttributes(attributes);
                attributesValueList.add(attributesValue);

            }
            attributesValueService.saveList(attributesValueList);
            result.setMessage("Succes");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("False");
        }
        return result;

    }

}
