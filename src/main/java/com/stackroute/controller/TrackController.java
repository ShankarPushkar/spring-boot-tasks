package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//RequestMapping is used for mapping of the link
@RequestMapping(value = "api/v1/")

public class TrackController {
    private TrackService trackService;

    //TrackService Constructor
    @Autowired
    public TrackController(TrackService trackService) {
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
    public ResponseEntity<?> trackSave(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.trackSave(track);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (TrackAlreadyExistException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
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
    //Delete Method for trackDeletbyID method, this method will delete the Track

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
    //Patch Method for trackUpdateByID method, this method will update the track

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
    //GET Method for getTrackByName, this method will retrieve all the Tracks By Name

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
