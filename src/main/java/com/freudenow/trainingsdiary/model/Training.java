package com.freudenow.trainingsdiary.model;

import java.sql.Timestamp;
import java.util.UUID;

public class Training {
    private UUID id;
    private Integer user_id;
    private Integer sport_id;
    private Integer sport_level_id;
    private Integer course_name_id;
    private Integer heartrate;
    private Integer heartrate_avg;
    private Integer heartrate_max;
    private Integer calories;
    private Float time_total;
    private Float distance_total;
    private String filename;
    private String map_data;
    private String height;
    private String comments;

    public Training(UUID id,
                    Integer user_id,
                    Integer sport_id,
                    Integer sport_level_id,
                    Integer course_name_id,
                    Float time_total,
                    Float distance_total,
                    String map_data,
                    String filename,
                    Timestamp start_time,
                    Integer heartrate,
                    String height,
                    String comments,
                    Integer heartrate_avg,
                    Integer heartrate_max,
                    Integer calories) {
        this.id = id;
        this.user_id = user_id;
        this.sport_id = sport_id;
        this.sport_level_id = sport_level_id;
        this.course_name_id = course_name_id;
        this.heartrate = heartrate;
        this.heartrate_avg = heartrate_avg;
        this.heartrate_max = heartrate_max;
        this.calories = calories;
        this.time_total = time_total;
        this.distance_total = distance_total;
        this.filename = filename;
        this.start_time = start_time;
        this.map_data = map_data;
        this.height = height;
        this.comments = comments;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setSport_id(Integer sport_id) {
        this.sport_id = sport_id;
    }

    public void setSport_level_id(Integer sport_level_id) {
        this.sport_level_id = sport_level_id;
    }

    public void setCourse_name_id(Integer course_name_id) {
        this.course_name_id = course_name_id;
    }

    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }

    public void setHeartrate_avg(Integer heartrate_avg) {
        this.heartrate_avg = heartrate_avg;
    }

    public void setHeartrate_max(Integer heartrate_max) {
        this.heartrate_max = heartrate_max;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setTime_total(Float time_total) {
        this.time_total = time_total;
    }

    public void setDistance_total(Float distance_total) {
        this.distance_total = distance_total;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setMap_data(String map_data) {
        this.map_data = map_data;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    private Timestamp start_time;




    public UUID getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getSport_id() {
        return sport_id;
    }

    public Integer getSport_level_id() {
        return sport_level_id;
    }

    public Integer getCourse_name_id() {
        return course_name_id;
    }

    public Integer getHeartrate() {
        return heartrate;
    }

    public Integer getHeartrate_avg() {
        return heartrate_avg;
    }

    public Integer getHeartrate_max() {
        return heartrate_max;
    }

    public Integer getCalories() {
        return calories;
    }

    public Float getTime_total() {
        return time_total;
    }

    public Float getDistance_total() {
        return distance_total;
    }

    public String getFilename() {
        return filename;
    }

    public String getMap_data() {
        return map_data;
    }

    public String getHeight() {
        return height;
    }

    public String getComments() {
        return comments;
    }

    public Timestamp getStart_time() {
        return start_time;
    }
}
