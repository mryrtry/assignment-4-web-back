package org.mryrt.web.PointCheck.Repository;

import org.mryrt.web.PointCheck.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ResultRepository extends JpaRepository<Result, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Result r WHERE r.createdById = :userId")
    void deleteAllByUserId(long userId);

}
