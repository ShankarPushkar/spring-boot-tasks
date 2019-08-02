package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
public interface TrackService {
Track getTrackById(int id) throws TrackNotFoundException;
Track trackSave(Track track) throws TrackAlreadyExistException;
List<Track> getAllTrack();
Track trackDeleteById(int id);
Track trackUpdateById(int id,Track track);
List<Track> getTrackByName(String name);
}
