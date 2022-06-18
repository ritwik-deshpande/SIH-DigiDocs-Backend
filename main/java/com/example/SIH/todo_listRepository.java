package com.example.SIH;

import Entities.todo_list;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface todo_listRepository extends CassandraRepository<todo_list, String> {

    @Override
    Optional<todo_list> findById(String id);

}