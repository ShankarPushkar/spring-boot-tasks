package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")

public class TrackController {
    private TrackService trackService;

    //TrackService Constructor


    public TrackController() {
    }

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
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

    @PostMapping("track/{id}")
    public ResponseEntity<?> trackUpdateById(@PathVariable int id, @RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity = new ResponseEntity("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
