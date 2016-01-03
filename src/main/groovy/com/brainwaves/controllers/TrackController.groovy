package com.brainwaves.controllers

import com.brainwaves.assembler.TrackResourceAssembler
import com.brainwaves.domain.Track
import com.brainwaves.services.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path="/track/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
class TrackController {
    @Autowired
    TrackRepository trackRepository
    @Autowired
    TrackResourceAssembler trackResourceAssembler


    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resource<Track>> get(@PathVariable("id") Long id) {

        Track inventory = trackRepository.findOne(id)

        Resource<Track> resource = trackResourceAssembler.toResource(inventory);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
