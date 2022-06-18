package com.example.SIH;

import Entities.Notifications;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationsRepository extends CassandraRepository<Notifications, String> {

    @Override
    Optional<Notifications> findById(String id);
}