package com.mindex.challenge.dao;
import org.springframework.stereotype.Repository;
import com.mindex.challenge.data.Compensation;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    Compensation findByEmployeeId(String id);

}
