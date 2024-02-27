package ru.gb.services;

import ru.gb.repositories.IRepository;
import ru.gb.repositories.NumberRepository;

import java.util.List;

public class NumberService {
    private IRepository repo;

    public NumberService(IRepository repo) {
        this.repo = repo;
    }
    public List<Number> getNumbers(){
        return repo.getNumbers();
    }
}
