package com.freudenow.trainingsdiary.dao.training;

import com.freudenow.trainingsdiary.model.Training;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingDao {
    UUID insertTraining(UUID id, Training training);

    default UUID insertTraining(Training training) {
        UUID id = UUID.randomUUID();
        return insertTraining(id, training);
    }

    List<Training> selectAllTrainings();

    Optional<Training> selectTraining(UUID id);

    int deleteTraining(UUID id);

    int updateTraining(UUID id, Training training);
}
