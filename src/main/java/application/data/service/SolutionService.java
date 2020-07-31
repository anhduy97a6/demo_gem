package application.data.service;

import application.data.model.Solution;

import java.util.List;

public interface SolutionService {
    List<Solution> findALl();
    boolean save(Solution solution);
    void deleteSolution(int id);
    Solution findById(int id);
}
