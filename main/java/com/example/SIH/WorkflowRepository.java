package com.example.SIH;

import Entities.Workflow;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkflowRepository extends CassandraRepository<Workflow, String> {

    @Query(allowFiltering = true)
    List<Workflow> findByUserIgnoreCase(String User);

    @Override
    Optional<Workflow> findById(String s);
}