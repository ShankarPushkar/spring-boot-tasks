package com.stackroute.domain;

public class Track {

    private int id;
    private String trackName;
    private String comment;
    //Constructor

    public Track(int id, String trackName, String comment) {
        this.id = id;
        this.trackName = trackName;
        this.comment = comment;
    }
//Getter and Setter method
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
// toString
    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
