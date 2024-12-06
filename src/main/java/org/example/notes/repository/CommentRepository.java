package org.example.notes.repository;

import org.example.notes.domain.entity.Comments;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface CommentsRepository extends CrudRepository<Comments, BigInteger> {

}
