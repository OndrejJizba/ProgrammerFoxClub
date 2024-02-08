package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxService {
    private List<Fox> foxList;

    public FoxService() {
        this.foxList = new ArrayList<>();
    }

    public void addFox (Fox fox) {
        foxList.add(fox);
    }

    public Fox findByName (String name) {
        return foxList.stream().filter(fox -> fox.getName().equals(name))
                .findFirst().orElse(null);
    }
}
