package org.maybank.com.Repository;

import org.maybank.com.entity.HeaderFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderFileRepository extends JpaRepository<HeaderFileEntity, Long> {

}
