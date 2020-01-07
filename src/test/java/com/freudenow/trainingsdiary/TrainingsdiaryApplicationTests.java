package com.freudenow.trainingsdiary;

import com.freudenow.trainingsdiary.api.TrainingController;

import static org.assertj.core.api.Assertions.assertThat;

import com.freudenow.trainingsdiary.dao.training.TrainingDataAccessService;
import com.freudenow.trainingsdiary.model.Training;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest()
class TrainingsdiaryApplicationTests {
    @Autowired
    private TrainingController controller;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void crudTraining() {
        UUID idOne = UUID.randomUUID();
        TrainingDataAccessService underTest = new TrainingDataAccessService(jdbcTemplate);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Training training1 = new Training(
                idOne, //uuid
                1, //user_id
                1, //sport_id
                1, //sport_level_id
                4, //course_name_id
                1.34543f, // time_toal
                1.3f, //distance_total
                "1", //map_data
                "filename", //filename
                timestamp, //start_time
                1, //heartrate
                "height",  //height
                "training1", //comment
                1, //heartrate_avg
                2, //heartrate_max
                1 //calories
        );
        UUID idTwo = UUID.randomUUID();
        Training training2 = new Training(
                idTwo, //uuid
                1, //user_id
                5, //sport_id
                2, //sport_level_id
                1, //course_name_id
                4.34543f, // time_toal
                1.3f, //distance_total
                "1", //map_data
                "filename", //filename
                timestamp, //start_time
                1, //heartrate
                "height",  //height
                "training2", //comment
                1, //heartrate_avg
                2, //heartrate_max
                1 //calories
        );
        underTest.insertTraining(idOne, training1);
        underTest.insertTraining(idTwo, training2);
        assertThat(underTest.selectTraining(idOne))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(training1));
        assertThat(underTest.selectTraining(idTwo))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(training2));

        Training updateTraining1 = new Training(
                idOne, //uuid
                1, //user_id
                1, //sport_id
                1, //sport_level_id
                1, //course_name_id
                2.34543f, // time_toal
                1.3f, //distance_total
                "1", //map_data
                "filename", //filename
                timestamp, //start_time
                1, //heartrate
                "height",  //height
                "training1a", //comment
                1, //heartrate_avg
                2, //heartrate_max
                1 //calories
        );
        assertThat(underTest.updateTraining(idOne, updateTraining1)).isEqualTo(1);
        assertThat(underTest.deleteTraining(idOne)).isEqualTo(1);
        assertThat(underTest.deleteTraining(idTwo)).isEqualTo(1);
    }
}
