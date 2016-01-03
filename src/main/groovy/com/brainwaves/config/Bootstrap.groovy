package com.brainwaves.config

import com.brainwaves.domain.Track
import com.brainwaves.domain.TrackCategory
import com.brainwaves.services.TrackCategoryRepository
import com.brainwaves.services.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct;



@Configuration
public class Bootstrap {

    @Autowired
    TrackRepository trackRepository

    @Autowired
    TrackCategoryRepository trackCategoryRepository


    @PostConstruct
    def init(){
        def categories = [
            new TrackCategory(
            name:"create",
            description: "ipsum lorem create",
            thumbnail: "https://pbs.twimg.com/profile_images/633782900077408256/F541mrSs_400x400.jpg"

            ),

            new TrackCategory(
                    name:"relax",
            description: "ipsum lorem relax",
                    thumbnail:"https://pbs.twimg.com/profile_images/590205977321984002/wiJx_lh3.jpg"
            ),
            new TrackCategory(
                    name:"sleep",
            description: "ipsum lorem sleep",
                    thumbnail: "https://static-s.aa-cdn.net/img/ios/949789164/e2d5f4697cde947639ebf834a24437b6"
            ),

            new TrackCategory(
                    name:"sos",
            description: "ipsum lorem sos",
                    thumbnail: "http://authentic-scandinavia.com/system/images/tours/photos/155/thumbnail.jpg"
            )
        ]

        trackCategoryRepository.save(categories)

        //-------//

        /*

Create1C30Min.mp3
Relax1C30Min.mp3
Sleep1C30Min.mp3

Create1B20Min.mp3
Relax1B20Min.mp3
Sleep1B20Min.mp3
SOS1A15Min.mp3
SOS1B15Min.mp3
SOS1C15Min.mp3

Create1A10Min.mp3
Relax1A10Min.mp3
Sleep1A10Min.mp3

* */

        def items = [new Track(
                name: 'Create1',
                length: 1000L,
                category: "create",
                description: "ipsum lorem",
                uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Create1A10Min.mp3"
        ),

        new Track(
                name: 'Relax1',
                length: 1000L,
                category: "relax",
                description: "ipsum lorem2",
                uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Relax1A10Min.mp3"
        ) ,
                new Track(
                name: 'Sleep1',
                length: 1100L,
                category: "sleep",
                description: "ipsum lorem3",
                uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Sleep1A10Min.mp3"
        ),

                new Track(
                        name: 'Create2',
                        length: 1000L,
                        category: "create",
                        description: "ipsum lorem",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Create1B20Min.mp3"
                ),

                new Track(
                        name: 'Relax2',
                        length: 1000L,
                        category: "relax",
                        description: "ipsum lorem2",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Relax1B20Min.mp3"
                ) ,
                new Track(
                        name: 'Sleep2',
                        length: 1100L,
                        category: "sleep",
                        description: "ipsum lorem3",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/Sleep1B20Min.mp3"
                ) ,
                new Track(
                        name: 'SOS1A',
                        length: 1000L,
                        category: "sos",
                        description: "ipsum lorem",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/SOS1A15Min.mp3"
                ),
                new Track(
                        name: 'SOS1B',
                        length: 1000L,
                        category: "sos",
                        description: "ipsum lorem2",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/SOS1B15Min.mp3"
                ) ,
                new Track(
                        name: 'SOS1C',
                        length: 1100L,
                        category: "sos",
                        description: "ipsum lorem3",
                        uri: "https://s3-us-west-1.amazonaws.com/alpha-tracks/SOS1C15Min.mp3"
                )


        ]
        trackRepository.save(items)

        println(trackRepository.findAll())


    }
}
