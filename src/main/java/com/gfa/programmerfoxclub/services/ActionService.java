package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Action;
import com.gfa.programmerfoxclub.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public void addToActionList(Action action){
        actionRepository.addToActionList(action);
    }

    public List<Action> getActionList(){
        return actionRepository.getActionList();
    }
}
