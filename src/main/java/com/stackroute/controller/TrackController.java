package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/")
public class TrackController {
    private TrackServiceImpl trackServiceImpl;

    //TrackService Constructor
    @Autowired
    public TrackController(TrackServiceImpl trackServiceImpl) {
        this.trackServiceImpl = trackServiceImpl;
    }

    //Get Method for getbyID method, this method finds a track by id
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackByID(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            trackServiceImpl.getTrackById(id);
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
        trackServiceImpl.trackSave(track);
        responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        return responseEntity;
    }

    //GET Method for getAllTrack method, this method sends all the track as list
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackServiceImpl.getAllTrack(), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> trackDeleteById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackServiceImpl.trackDeleteById(id);
        responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> trackUpdateById(@RequestBody Track track, @PathVariable("id") int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackServiceImpl.trackUpdateById(id, track);
        responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        return responseEntity;
    }

//    @GetMapping("tracks/{name}")
//    public ResponseEntity<?> getTrackByName(@PathVariable("name") String name) {
//        ResponseEntity responseEntity;
//        try {
//            responseEntity = new ResponseEntity(trackServiceImpl.getTrackByName(name), HttpStatus.CREATED);
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }
}
