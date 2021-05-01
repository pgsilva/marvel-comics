package com.dojo.marvelcomics.service

import com.dojo.marvelcomics.data.response.MarvelApiCharacterResponse
import com.dojo.marvelcomics.repository.MarvelApiRepository
import org.springframework.stereotype.Service

@Service
class MarvelApiService(val repository: MarvelApiRepository) {


    fun listMarvelCharacters(
        name: String?,
        nameStartsWith: String?,
        modifiedSince: String?,
        comics: String?,
        series: String?,
        events: String?,
        stories: String?,
        orderBy: String?,
        limit: String?,
        offset: String?
    ): MarvelApiCharacterResponse? {
        return repository.getPublicCharacters(
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
    }

    fun characterById(characterId: String): MarvelApiCharacterResponse? {
        return repository.getPublicCharacterById(characterId)
    }
}