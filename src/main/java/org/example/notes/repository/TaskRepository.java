package org.example.notes.repository;

import org.example.notes.domain.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, UUID> {

}
