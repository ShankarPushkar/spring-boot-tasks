package com.stackroute.service;

import com.stackroute.domain.Track;

public interface TrackService {
Track getTrackById();
Track trackSave();
Track getAllTrack();
Track trackDeleteByID();
Track trackUpdateByID();
}
