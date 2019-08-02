package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Track {
    @Id
    private int id;
    private String trackName;
    private String comment;
}
