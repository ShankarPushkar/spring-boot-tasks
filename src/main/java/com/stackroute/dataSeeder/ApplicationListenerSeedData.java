package com.stackroute.dataSeeder;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class ApplicationListenerSeedData implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;

    @Autowired
    public ApplicationListenerSeedData(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context Event Received");
        Track track=new Track(1,"Gana","mast");
        trackRepository.save(track);
        Track track2=new Track(2,"Ganaa","masttt");
        trackRepository.save(track2);
        Track track3=new Track(3,"Ganaaa","masttt");
        trackRepository.save(track3);
        Track track4=new Track(4,"Ganaaaa","masttttt");
        trackRepository.save(track4);
        Track track5=new Track(5,"Ganaaa","masttttt");
        trackRepository.save(track5);

    }
}
