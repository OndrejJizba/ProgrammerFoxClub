package com.gfa.programmerfoxclub.repositories;

import com.gfa.programmerfoxclub.models.Trick;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrickRepository {

    private List<Trick> trickList;
    private List<Trick> learntTricks;

    public TrickRepository(){
        this.trickList = new ArrayList<>();
        this.learntTricks = new ArrayList<>();
        trickList.add(new Trick("write HTML"));
        trickList.add(new Trick("learn CSS"));
        trickList.add(new Trick("master Java"));
    }

    public List<Trick> getTrickList(){
        return trickList;
    }

    public List<Trick> getLearntTricksList(){
        return learntTricks;
    }
}
