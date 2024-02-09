package com.gfa.programmerfoxclub.repositories;

import com.gfa.programmerfoxclub.models.Action;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActionRepository {

    private List<Action> actionList;

    public ActionRepository() {
        this.actionList = new ArrayList<>();
    }

    public List<Action> getActionList(){
        return actionList;
    }

    public void addToActionList(Action action) {
        actionList.add(action);
    }
}
