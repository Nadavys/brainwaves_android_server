package com.brainwaves.assembler

import com.brainwaves.controllers.TrackController;
import com.brainwaves.domain.Track
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component
import org.springframework.util.Assert


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

@Component
public class TrackResourceAssembler extends ResourceAssemblerSupport<Track, Resource<Track>> {

    TrackResourceAssembler() {
        super(TrackController.class, (Class<Resource<Track>>) new Resource<Track>(new Track()).getClass())
    }

    @Override
    Resource<Track> toResource(Track entity) {
        Assert.notNull(entity)

        Resource<Track> resource = new Resource<>(entity)
        resource.add(linkTo(TrackController.class, entity.id).withSelfRel())
        resource.add(new Link(entity.uri).withRel("media"))
        if(entity.thunmbnail)[
                resource.add(new Link(entity.thunmbnail).withRel("thumbnail"))
        ]
        if(entity.image)[
                resource.add(new Link(entity.image).withRel("image"))
        ]

        return resource
    }

}

