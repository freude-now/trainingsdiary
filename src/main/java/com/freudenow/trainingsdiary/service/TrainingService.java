package com.freudenow.trainingsdiary.service;

import com.freudenow.trainingsdiary.dao.training.TrainingDao;
import com.freudenow.trainingsdiary.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingService {
    private final TrainingDao trainingDao;

    @Autowired
    public TrainingService(@Qualifier("postgres") TrainingDao trainingDao) {
        this.trainingDao = trainingDao;
    }

    public UUID insertTraining(Training training) {
        return trainingDao.insertTraining(training);
    }

    public List<Training> getAllTrainings() {
        return trainingDao.selectAllTrainings();
    }

    public Optional<Training> getTraining(UUID id) {
        return trainingDao.selectTraining(id);
    }

    public int deleteTraining(UUID id) {
        return trainingDao.deleteTraining(id);
    }

    public int updateTraining(UUID id, Training training) {
        return trainingDao.updateTraining(id, training);
    }
}
