package com.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BookJpaRepository extends JpaRepository<BookEntity, UUID> {
}
