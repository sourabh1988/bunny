package com.rbc.bunny.repositories;

import com.rbc.bunny.entities.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends ListCrudRepository<Command, String> {
}
