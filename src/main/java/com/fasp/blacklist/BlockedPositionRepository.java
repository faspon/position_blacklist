package com.fasp.blacklist;
import com.fasp.blacklist.entity.BlockedPosition;
import org.springframework.data.jpa.repository.JpaRepository;

interface BlockedPositionRepository extends JpaRepository<BlockedPosition, Long> {

}