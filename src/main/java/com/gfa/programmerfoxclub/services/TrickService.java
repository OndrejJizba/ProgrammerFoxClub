package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Trick;
import com.gfa.programmerfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        currentTrick = new Trick(trick);
        trickRepository.getLearntTricksList().add(currentTrick);
        for (int i = 0; i < getTrickList().size(); i++) {
            if (Objects.equals(currentTrick.getTrickName(), getTrickList().get(i).getTrickName())) {
                getTrickList().remove(i);
            }
        }
    }

    public List<Trick> getListOfLearntTricks(){
        return trickRepository.getLearntTricksList();
    }

    public int getNumberOfTricks(){
        return trickRepository.getLearntTricksList().size();
    }
}
