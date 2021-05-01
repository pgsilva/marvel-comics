package com.dojo.marvelcomics.controller

import com.dojo.marvelcomics.data.ApiConstants.ImageSizes
import com.dojo.marvelcomics.data.response.Thumbnail
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MarvelApiImageController {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("image")
    @ApiOperation(value = "make image url, parameters optional accepted: portrait, standard, landscape, detail")
    fun makeImageUrl(
        @RequestBody thumbnail: Thumbnail,
        @RequestParam(value = "type", required = false) type: String?
    ): ResponseEntity<*> =
        ResponseEntity.ok(makeUrl(thumbnail, type)).also {
            logger.info("Post make Image Url")
        }


    private fun makeUrl(thumbnail: Thumbnail, type: String?): String {
        type?.let {
            ImageSizes.values().forEach { size ->
                if (type.toUpperCase() == size.name)
                    return "${thumbnail.path}/${size.value}.${thumbnail.extension}"
            }
        }
        return "${thumbnail.path}.${thumbnail.extension}"
    }
}