package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
            throw new TrackNotFoundException("Track Not Found");
        }
        return trackRepository.findById(id).get();
    }

    @Override
    public Track trackSave(Track track) throws TrackAlreadyExistException {
        if (trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistException("Track Already There");
        }
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track trackDeleteById(int id) {
        Optional<Track> optionalTrack = trackRepository.findById(id);
        trackRepository.deleteById(id);
        return optionalTrack.get();
    }

    @Override
    public Track trackUpdateById(int id, Track track) {

        return null;
    }

    @Override
    public List<Track> getTrackByName(String name) {
      return trackRepository.getTrackByName(name);
    }

}
