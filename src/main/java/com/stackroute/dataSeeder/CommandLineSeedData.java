package com.stackroute.dataSeeder;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineSeedData implements CommandLineRunner {
    private TrackRepository trackRepository;
    @Autowired
    public CommandLineSeedData(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLine Event Received");
        Track track=new Track(9,"Push","mast");
        trackRepository.save(track);
        Track track2=new Track(10,"Gangagaa","sttt");
        trackRepository.save(track2);
        Track track3=new Track(11,"Gajajnaaa","matt");
        trackRepository.save(track3);
        Track track4=new Track(12,"Ganaajwdajaa","ma");
        trackRepository.save(track4);
        Track track5=new Track(13,"Ganashsa","mattt");
        trackRepository.save(track5);

    }
}
