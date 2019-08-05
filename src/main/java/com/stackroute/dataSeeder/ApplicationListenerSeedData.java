package com.stackroute.dataSeeder;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@PropertySource("classpath:application.properties")
class ApplicationListenerSeedData implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;
    //Getting the Data from application.properties
    @Value("${track1.id}")
    private int id;
    @Value("${track1.trackName}")
    private String trackName;
    @Value("${track1.comment}")
    private String comment;
    Track track1= new Track();

    @Autowired
    public ApplicationListenerSeedData(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context Event Received");
        //Setting the data
        track1.setId(id);
        track1.setTrackName(trackName);
        track1.setComment(comment);
        trackRepository.save(track1);

    }
}
