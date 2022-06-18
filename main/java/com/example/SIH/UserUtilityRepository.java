package com.example.SIH;

import Entities.UserUtility;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserUtilityRepository extends CassandraRepository<UserUtility, String> {

    @AllowFiltering
    List<UserUtility> findByUsername(String username);

    @AllowFiltering
    List<UserUtility> findByName(String name);

    @AllowFiltering
    List<UserUtility> findByEmailID(String emailID);

    @Override
    Optional<UserUtility> findById(String s);
}