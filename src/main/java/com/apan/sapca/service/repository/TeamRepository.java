package com.apan.sapca.service.repository;

import com.apan.sapca.service.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by apanc on 1/23/2016.
 */

public interface TeamRepository extends JpaRepository<Team, Long> {
}
