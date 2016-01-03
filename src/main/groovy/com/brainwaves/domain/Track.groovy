package com.brainwaves.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.ToString
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@ToString
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id
    String name
    Long length
    String category
    String description

    @JsonIgnore
    String thunmbnail
    @JsonIgnore
    String image
    @JsonIgnore
    String uri
    @JsonIgnore
    Boolean isEnabled = true
}
