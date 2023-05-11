package com.example.application.data.repository;

import com.example.application.data.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("select c from Phone c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.category) like lower(concat('%', :searchTerm, '%'))")
    List<Phone> search(@Param("searchTerm") String searchTerm);
}
