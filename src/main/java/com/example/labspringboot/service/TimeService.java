package com.example.labspringboot.service;

import com.example.labspringboot.domain.Times;
import com.example.labspringboot.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public List<Times> getTimes() { return repository.getTimes();
    }
}
