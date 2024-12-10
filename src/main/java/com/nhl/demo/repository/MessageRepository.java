package com.nhl.demo.repository;

import com.nhl.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MessageRepository extends JpaRepository<Message, Long> {
    
    Message findByTitle(String title);
    
    @Query("select m from Message m where m.title = :title")
    Message findByTitleUsingJPQL(String title);
    
}
