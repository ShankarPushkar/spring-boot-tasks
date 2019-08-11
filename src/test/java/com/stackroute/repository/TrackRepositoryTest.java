package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;

    private Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setId(99);
        track.setTrackName("John");
        track.setComment("Jenny");
    }

    @After
    public void tearDown() {
        track=null;
        trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser() {
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(99, fetchTrack.getId());

    }

    @Test
    public void testSaveUserFailure() {
        Track testTrack = new Track(34, "Harry", "john");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack, track);
    }

    @Test
    public void testGetAllUser() {
        Track track = new Track(10, "Johny", "Jenny");
        Track track1 = new Track(20, "Harry", "Jenny");
        trackRepository.save(track);
        trackRepository.save(track1);
        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Johny", list.get(0).getTrackName());

    }


}