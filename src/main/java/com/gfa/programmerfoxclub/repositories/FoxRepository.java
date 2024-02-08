package com.gfa.programmerfoxclub.repositories;

import com.gfa.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoxRepository {
    private List<Fox> foxList;

    public FoxRepository(){
        foxList = new ArrayList<>();
    }

    public void add(Fox fox){
        foxList.add(fox);
    }

    public List<Fox> getListOfFoxes(){
        return foxList;
    }

}
