package com.freudenow.trainingsdiary.api;

import com.freudenow.trainingsdiary.model.Training;
import com.freudenow.trainingsdiary.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TrainingController {
    private final TrainingService trainingService;
    private static List<Training> trainings = new ArrayList<Training>();

    @Value("${welcome.message}")
    public String message;
    @Value("${error.message}")
    public String errorMessage;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public UUID insertTraining(@RequestBody Training training) {
        return trainingService.insertTraining(training);
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

//    @GetMapping
//    public List<Training> getAllTrainings() {
//        return trainingService.getAllTrainings();
//
//    }
    @GetMapping("/trainings/list.html")
    public String all(Model model) {
        List<Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings", trainings);
        return "trainings/list";
    }
//
//    @GetMapping
//    public Training getTraining(UUID id) {
//        return trainingService.getTraining(id).orElse(null);
//    }
//
//    @DeleteMapping
//    public void deleteTraining(UUID id) {
//        trainingService.deleteTraining(id);
//    }
//
//    @PutMapping
//    public void updateTraining(UUID id, Training training){
//        trainingService.updateTraining(id, training);
//    }

}
