package com.example.SIH;

import Entities.Group;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends CassandraRepository<Group, String> {

    @Override
    Optional<Group> findById(String s);
}