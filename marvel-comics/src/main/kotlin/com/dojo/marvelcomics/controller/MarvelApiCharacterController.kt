package com.dojo.marvelcomics.controller


import com.dojo.marvelcomics.service.MarvelApiService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MarvelApiCharacterController(val service: MarvelApiService) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/characters")
    fun getMarvelCharacters(
        @RequestParam(value = "name", required = false) name: String?,
        @RequestParam(value = "nameStartsWith", required = false) nameStartsWith: String?,
        @RequestParam(value = "modifiedSince", required = false) modifiedSince: String?,
        @RequestParam(value = "comics", required = false) comics: String?,
        @RequestParam(value = "series", required = false) series: String?,
        @RequestParam(value = "events", required = false) events: String?,
        @RequestParam(value = "stories", required = false) stories: String?,
        @RequestParam(value = "orderBy", required = false) orderBy: String?,
        @RequestParam(value = "limit", required = false) limit: String?,
        @RequestParam(value = "offset", required = false) offset: String?
    ): ResponseEntity<*> =
        ResponseEntity.ok(
            service.listMarvelCharacters(
                name = name,
                nameStartsWith = nameStartsWith,
                modifiedSince = modifiedSince,
                comics = comics,
                series = series,
                events = events,
                stories = stories,
                orderBy = orderBy,
                limit = limit,
                offset = offset
            )
        ).also {
            logger.info("Get all public characters from API")
        }

    @GetMapping("/characters/{characterId}")
    fun getMarvelCharacterById(
        @RequestParam(value = "characterId") characterId: String
    ): ResponseEntity<*> =
        ResponseEntity.ok(
            service.characterById(
                characterId = characterId
            )
        ).also {
            logger.info("Get public character by id from API")
        }
}