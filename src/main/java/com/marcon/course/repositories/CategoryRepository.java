package com.marcon.course.repositories;

import com.marcon.course.entities.Category;
import com.marcon.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
