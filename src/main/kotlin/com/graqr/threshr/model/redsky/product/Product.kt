package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graqr.threshr.model.queryparam.Tcin
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class Product(
        @JsonProperty("__typename") val typename: String,
        val tcin: Tcin,
        @Nullable @JsonProperty("original_tcin") val originalTcin: String,
        val category: Category,
        @JsonProperty("ratings_and_reviews") val ratingsAndReviews: RatingsAndReviews,
        val item: Item,
        @JsonProperty("finds_stories")
        val findStories: List<FindsStory>,
        @Nullable @JsonProperty("finds_posts")
        val findsPosts: List<FindsPost>,
        val price: Price,
        val promotions: List<Any>
) {

}