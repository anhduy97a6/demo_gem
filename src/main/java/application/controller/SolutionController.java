package application.controller;

import application.data.model.Attributes;
import application.data.model.AttributesValue;
import application.data.model.Employee;
import application.data.model.Solution;
import application.data.service.AttributesService;
import application.data.service.EmployeeService;
import application.data.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;
    @Autowired
    AttributesService attributesService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String solution(Model model) {
        List<Solution> solutionList = solutionService.findALl();

        List<Attributes> attributesList = attributesService.findAll();


        model.addAttribute("solutionList", solutionList);
        model.addAttribute("attributesList", attributesList);
        return "/solution/solution";
    }

    @GetMapping("/add")
    public String addSolution(Model model) {
        List<Attributes> attributesList = attributesService.findAll();
        List<AttributesValue> attributesValueModelList = new ArrayList<>();
        Solution solution = new Solution();

        for (
                Attributes attributesModel : attributesList) {
            AttributesValue attributesValue = new AttributesValue();
            attributesValue.setAttributes(attributesModel);
            attributesValue.setSolution(solution);
            attributesValueModelList.add(attributesValue);
        }




        solution.setAttributesValueList(attributesValueModelList);

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("solution", solution);

        return "/solution/add-solution";
    }

    @PostMapping("/add")
    public String postAddSolution(Model model,
                                  @ModelAttribute("solution") Solution solution) {




        if (solutionService.save(solution)) {
            return "redirect:/solution?addSuccess";
        }
        else
            return "redirect:/solution/add?addSuccess";



    }
    @GetMapping("/edit/{solutionId}")
    public String getEditSolution(Model model,
                                  @PathVariable int solutionId) {
        Solution solution = solutionService.findById(solutionId);

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("solution", solution);
        return "/solution/add-solution";
    }

//    @GetMapping("/update")
//    public String getUpdateSolution(Model model,
//                                  @ModelAttribute("solution") Solution solution) {
//
//
//
//
//        if (solutionService.save(solution)) {
//            return "redirect:/solution?addSuccess";
//        }
//        else
//            return "redirect:/solution/add?addSuccess";
//    }

    @GetMapping("/delete/{solutionId}")
    public String deleteSolution(Model model,
                                 @PathVariable int solutionId) {
        solutionService.deleteSolution(solutionId);
        return "redirect:/solution";
    }
}
