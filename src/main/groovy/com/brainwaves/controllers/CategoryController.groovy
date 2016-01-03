package com.brainwaves.controllers

import com.brainwaves.assembler.TrackResourceAssembler
import com.brainwaves.domain.Track
import com.brainwaves.domain.TrackCategory
import com.brainwaves.services.TrackCategoryRepository
import com.brainwaves.services.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

/**
 * Created with IntelliJ IDEA.
 * User: nadav
 * Date: 12/30/15
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(path="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
class CategoryController {
    @Autowired
    TrackRepository trackRepository
    @Autowired
    TrackResourceAssembler trackResourceAssembler
    @Autowired
    TrackCategoryRepository trackCategoryRepository

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity get(@PathVariable("name") String category){
        category = category.toLowerCase()
        def resource = toResource(category)
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    def toResource(String categoryName){
        TrackCategory category = trackCategoryRepository.findByName(categoryName)

        Resource<TrackCategory> resource = new Resource<>(category)
        trackRepository.findAll().findAll{it.category == category.name}.each { Track track->
            resource.add(linkTo(TrackController.class, track.id).withRel("tracks"))
        }
        resource.add(linkTo(CategoryController.class, category.name).withSelfRel())


        resource

    }
}