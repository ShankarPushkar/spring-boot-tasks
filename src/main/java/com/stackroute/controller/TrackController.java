package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TrackController {
    private TrackService trackService;

    //TrackService Constructor
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping("track")
    public ResponseEntity<?> getByID(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById();
            responseEntity=new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("track")
    public ResponseEntity<?> trackSave(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.trackSave();
            responseEntity=new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTrack(){
        ResponseEntity responseEntity;
        try {
            trackService.getAllTrack();
            responseEntity=new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> trackDeleteById(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.trackDeleteByID();
            responseEntity=new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("track")
    public ResponseEntity<?> trackUpdateById(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById();
            responseEntity=new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
