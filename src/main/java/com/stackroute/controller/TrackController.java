package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")

public class TrackController {
    private TrackService trackService;

    //TrackService Constructor
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //Get Method for getbyID method, this method finds a track by id
    @GetMapping("track/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //POST Method for trackSave method, this method saves the track
    @PostMapping("track")
    public ResponseEntity<?> trackSave(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.trackSave(track);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    //GET Method for getAllTrack method, this method sends all the track as list
    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {
        ResponseEntity responseEntity;
        try {
            trackService.getAllTrack();
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> trackDeleteById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.trackDeleteById(id);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PatchMapping("track/{id}")
    public ResponseEntity<?> trackUpdateById(@RequestBody Track track, @PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            trackService.trackUpdateById(id, track);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
