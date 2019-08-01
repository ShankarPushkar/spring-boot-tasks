package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.findById(id).get();
    }

    @Override
    public Track trackSave(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track trackDeleteById(int id) {
        return null;
    }

    @Override
    public Track trackUpdateById(int id) {
        return null;
    }
}
