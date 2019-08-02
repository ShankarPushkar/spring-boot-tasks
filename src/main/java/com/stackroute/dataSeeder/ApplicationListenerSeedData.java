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
        Track track=new Track(1,"Hello","Hello");
        trackRepository.save(track);
        Track track2=new Track(2,"How","How");
        trackRepository.save(track2);
        Track track3=new Track(3,"Are","Are");
        trackRepository.save(track3);
        Track track4=new Track(4,"You","You");
        trackRepository.save(track4);
        Track track5=new Track(5,"Mast?","Mastt");
        trackRepository.save(track5);

    }
}
