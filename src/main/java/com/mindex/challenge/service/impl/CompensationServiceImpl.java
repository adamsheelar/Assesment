package com.mindex.challenge.service.impl;

import com.mindex.challenge.service.CompensationService;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompensationServiceImpl implements CompensationService{

    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
  
    @Autowired
    private  CompensationRepository compRepos;


    
    public Compensation create(Compensation compensation){
        LOG.debug("Creating Compensaion [{}]", compensation); 
        compRepos.insert(compensation);
        return compensation;
    }
    

    public Compensation read(String employeeId){
        LOG.debug("Reading Compensation [{}]", employeeId);
   

        Compensation compensation = compRepos.findByEmployeeId(employeeId);

        if(compensation == null){
            throw new RuntimeException("Employee not found: " + employeeId);

        }
        return compensation;
    }
}
