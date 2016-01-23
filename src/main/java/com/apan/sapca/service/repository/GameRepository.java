package com.apan.sapca.service.repository;

import com.apan.sapca.service.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by apanc on 1/23/2016.
 */

public interface GameRepository extends JpaRepository<Game, Long> {
}
