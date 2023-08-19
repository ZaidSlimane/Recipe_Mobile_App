package com.example.intojetpackcompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val title: String? = null,
    val featured_image: String? = null,
    val rating: Int? = null,
    val source_url: String? = null,
    val description: String? = null,
    val cooking_instructions: String? = null,
    val ingredients: List<String>?= null,
): Parcelable {
}