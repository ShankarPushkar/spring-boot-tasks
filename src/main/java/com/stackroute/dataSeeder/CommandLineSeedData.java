//package com.stackroute.dataSeeder;
//
//import com.stackroute.domain.Track;
//import com.stackroute.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CommandLineSeedData implements CommandLineRunner {
//    private TrackRepository trackRepository;
//    @Autowired
//    public CommandLineSeedData(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("CommandLine Event Received");
//        Track track=new Track(6,"Atul","Kumar");
//        trackRepository.save(track);
//        Track track2=new Track(7,"Samresh","Babu");
//        trackRepository.save(track2);
//        Track track3=new Track(8,"Sneha","M");
//        trackRepository.save(track3);
//        Track track4=new Track(9,"Raju","Chacha");
//        trackRepository.save(track4);
//        Track track5=new Track(11,"Shiv","Happy");
//        trackRepository.save(track5);
//
//    }
//}
