package com.dojo.marvelcomics.network

import com.dojo.marvelcomics.data.ApiConstants.MARVEL_API_KEY
import com.dojo.marvelcomics.data.ApiConstants.MARVEL_API_URL
import com.dojo.marvelcomics.data.response.MarvelApiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "marvelApiClient", url = MARVEL_API_URL)
interface MarvelApiClient {

    @GetMapping("v1/public/characters")
    fun getPublicCharacters(
        @RequestParam(value = "apikey", defaultValue = MARVEL_API_KEY) apikey: String,
        @RequestParam(value = "hash") hash: String,
        @RequestParam(value = "ts") ts: String,
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
    ): MarvelApiResponse
}