package com.brainwaves.services

import com.brainwaves.domain.TrackCategory
import org.springframework.data.repository.CrudRepository

public interface TrackCategoryRepository extends CrudRepository<TrackCategory, String>{
    public TrackCategory findByName(String name)
}
