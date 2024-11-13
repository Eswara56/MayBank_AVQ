package org.maybank.com.Repository;

import org.maybank.com.entity.DetailFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailFileRepository extends JpaRepository<DetailFileEntity, Long> {

}
