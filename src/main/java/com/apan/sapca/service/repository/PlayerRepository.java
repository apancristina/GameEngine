package com.apan.sapca.service.repository;

import com.apan.sapca.service.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by apanc on 1/22/2016.
 */

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
