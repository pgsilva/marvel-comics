package com.dojo.marvelcomics.repository

import com.dojo.marvelcomics.data.ApiConstants.MARVEL_API_HASH
import com.dojo.marvelcomics.data.ApiConstants.MARVEL_API_KEY
import com.dojo.marvelcomics.data.ApiConstants.MARVEL_API_TS
import com.dojo.marvelcomics.data.response.MarvelApiCharacterResponse
import com.dojo.marvelcomics.network.MarvelApiCharacterClient
import org.springframework.stereotype.Repository

@Repository
class MarvelApiRepository(val client: MarvelApiCharacterClient) {

    fun getPublicCharacters(
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

        return try {
            client.getPublicCharacters(
                hash = MARVEL_API_HASH,
                ts = MARVEL_API_TS,
                apikey = MARVEL_API_KEY,
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
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun getPublicCharacterById(characterId: String): MarvelApiCharacterResponse? {
        return try {
            client.getPublicCharacterById(
                hash = MARVEL_API_HASH,
                ts = MARVEL_API_TS,
                apikey = MARVEL_API_KEY,
                characterId = characterId
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}
