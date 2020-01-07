package com.freudenow.trainingsdiary.dao.training;

import com.freudenow.trainingsdiary.model.Training;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class TrainingRowMapper implements RowMapper<Training> {

    @Override
    public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Training(
                UUID.fromString(rs.getString("id")),
                rs.getInt("user_id"),
                rs.getInt("sport_id"),
                rs.getInt("sport_level_id"),
                rs.getInt("course_name_id"),
                rs.getFloat("time_total"),
                rs.getFloat("distance_total"),
                rs.getString("map_data"),
                rs.getString("filename"),
                rs.getTimestamp("start_time"),
                rs.getInt("heartrate"),
                rs.getString("height"),
                rs.getString("comments"),
                rs.getInt("heartrate_avg"),
                rs.getInt("heartrate_max"),
                rs.getInt("calories")
        );
    }
}
