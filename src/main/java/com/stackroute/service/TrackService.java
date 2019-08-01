package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {
Track getTrackById(int id);
Track trackSave(Track track);
List<Track> getAllTrack();
Track trackDeleteById(int id);
Track trackUpdateById(int id,Track track);
}
