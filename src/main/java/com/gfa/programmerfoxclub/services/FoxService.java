package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Fox;
import com.gfa.programmerfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoxService {
    private final FoxRepository foxRepository;
    private Fox currentFox;


    @Autowired
    public FoxService(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

        public void addFox (Fox fox){
            foxRepository.add(fox);
        }

        public Fox findByName (String name){
            return foxRepository.getListOfFoxes().stream().filter(fox -> fox.getName().equals(name))
                    .findFirst().orElse(null);
        }

        public List<Fox> getFoxList(){
            return foxRepository.getListOfFoxes();
        }

        public void setCurrentFox(String name){
            currentFox = new Fox(name);
        }

        public String getCurrentFox(){
            if (currentFox == null) return "fox without a name";
            else return currentFox.getName();
        }
    }