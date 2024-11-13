package org.maybank.com.Repository;

import org.maybank.com.entity.TrailerFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerFileRepository extends JpaRepository<TrailerFileEntity, Long> {

}
