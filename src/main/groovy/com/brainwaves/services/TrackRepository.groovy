package com.brainwaves.services

import com.brainwaves.domain.Track
import org.springframework.data.repository.CrudRepository

public interface TrackRepository extends CrudRepository<Track, Long>{
}
