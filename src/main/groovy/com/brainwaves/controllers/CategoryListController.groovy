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
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
class CategoryListController {
    @Autowired
    TrackRepository trackRepository
    @Autowired
    TrackResourceAssembler trackResourceAssembler
    @Autowired
    TrackCategoryRepository trackCategoryRepository

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity get(){

        def resource = toResource()
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    def toResource(){
        Resource<Object> resource = new Resource<>()
        trackCategoryRepository.findAll().each { TrackCategory category ->
            resource.add(linkTo(CategoryController.class, category.name.toLowerCase()).withRel("categories"))
        }

        resource

    }
}
