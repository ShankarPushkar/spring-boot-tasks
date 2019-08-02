package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/")

public class TrackController {
    private TrackService trackService;

    //TrackService Constructor
    @Autowired
    public TrackController(@Qualifier("dummy") TrackService trackService) {
        this.trackService = trackService;
    }

    //Get Method for getbyID method, this method finds a track by id
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackByID(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    //POST Method for trackSave method, this method saves the track
    @PostMapping("track")
    public ResponseEntity<?> trackSave(@RequestBody Track track) throws TrackAlreadyExistException {
        ResponseEntity responseEntity;

        trackService.trackSave(track);
        responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);

        return responseEntity;
    }

    //GET Method for getAllTrack method, this method sends all the track as list
    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getAllTrack(), HttpStatus.CREATED);
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

    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable("name") String name) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getTrackByName(name), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
