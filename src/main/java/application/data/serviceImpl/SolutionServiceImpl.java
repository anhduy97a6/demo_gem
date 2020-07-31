package application.data.serviceImpl;

import application.data.model.Solution;
import application.data.repository.SolutionRepository;
import application.data.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    SolutionRepository solutionRepository;

    @Override
    public List<Solution> findALl() {
        return solutionRepository.findAll();
    }

    @Override
    public boolean save(Solution solution) {
        try {
            solutionRepository.save(solution);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteSolution(int id) {
        solutionRepository.delete(id);
    }

    @Override
    public Solution findById(int id) {
        return solutionRepository.findOne(id);
    }
}
