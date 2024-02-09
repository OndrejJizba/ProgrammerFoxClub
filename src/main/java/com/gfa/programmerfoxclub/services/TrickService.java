package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Trick;
import com.gfa.programmerfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrickService {
    private final TrickRepository trickRepository;
    private Trick currentTrick;

    @Autowired
    public TrickService(TrickRepository trickRepository) {
        this.trickRepository = trickRepository;
    }

    public List<Trick> getTrickList(){
        return trickRepository.getTrickList();
    }

    public void addTrickToLearnt (String trick){
        trickRepository.getLearntTricksList().add(new Trick(trick));
    }

    public List<Trick> getListOfLearntTricks(){
        return trickRepository.getLearntTricksList();
    }

    public int getNumberOfTricks(){
        return trickRepository.getLearntTricksList().size();
    }
}
