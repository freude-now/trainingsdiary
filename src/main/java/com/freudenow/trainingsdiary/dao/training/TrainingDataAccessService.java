package com.freudenow.trainingsdiary.dao.training;

import com.freudenow.trainingsdiary.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TrainingDataAccessService implements TrainingDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainingDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID insertTraining(UUID id, Training training) {

        String sql = "INSERT INTO trainings( id,\n" +
                "         user_id,\n" +
                "         sport_id,\n" +
                "         sport_level_id,\n" +
                "         course_name_id,\n" +
                "         time_total,\n" +
                "         distance_total,\n" +
                "         map_data,\n" +
                "         filename,\n" +
                "         start_time,\n" +
                "         heartrate,\n" +
                "         height,\n" +
                "         comments,\n" +
                "         heartrate_avg,\n" +
                "         heartrate_max,\n" +
                "         calories ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                training.getId(),
                training.getUser_id(),
                training.getSport_id(),
                training.getSport_level_id(),
                training.getCourse_name_id(),
                training.getTime_total(),
                training.getDistance_total(),
                training.getMap_data(),
                training.getFilename(),
                training.getStart_time(),
                training.getHeartrate(),
                training.getHeight(),
                training.getComments(),
                training.getHeartrate_avg(),
                training.getHeartrate_max(),
                training.getCalories());
        return id;
    }

    @Override
    public List<Training> selectAllTrainings() {
        final String sql = "SELECT * FROM trainings";
        return jdbcTemplate.query(sql, new TrainingRowMapper());
    }


    @Override
    public Optional<Training> selectTraining(UUID id) {
        final String sql = "SELECT * FROM trainings WHERE id = ?";
        Training training = jdbcTemplate.queryForObject(sql, new Object[]{id}, new TrainingRowMapper());
        return Optional.ofNullable(training);
    }

    @Override
    public int deleteTraining(UUID id) {
        String query = "DELETE FROM trainings WHERE id = ?";

        int status = jdbcTemplate.update(query, id);
        if (status != 0) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public int updateTraining(UUID id, Training training) {
        String query = "UPDATE trainings SET " +
                "user_id = ?, " +
                "sport_id = ?," +
                "sport_level_id = ?, " +
                "course_name_id = ?, " +
                "time_total = ?, " +
                "distance_total = ?, " +
                "map_data = ?, " +
                "filename = ?, " +
                "start_time = ?, " +
                "heartrate = ?, " +
                "height = ?, " +
                "comments = ?, " +
                "heartrate_avg = ?, " +
                "heartrate_max = ?, " +
                "calories = ? " +
                "WHERE id = ?";
        int status = jdbcTemplate.update(query,
                training.getUser_id(),
                training.getSport_id(),
                training.getSport_level_id(),
                training.getCourse_name_id(),
                training.getTime_total(),
                training.getDistance_total(),
                training.getMap_data(),
                training.getFilename(),
                training.getStart_time(),
                training.getHeartrate(),
                training.getHeight(),
                training.getComments(),
                training.getHeartrate_avg(),
                training.getHeartrate_max(),
                training.getCalories(),
                id
        );
        if (status != 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
