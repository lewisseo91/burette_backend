package com.takeon.burette.article.repository;

import com.takeon.burette.article.domain.MainPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainPageRepository extends JpaRepository<MainPage, Long> {
}
