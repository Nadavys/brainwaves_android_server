package com.brainwaves.domain

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.Id

@ToString
@Entity
class TrackCategory {
    @Id
    String name
    String description
    String thumbnail

}
