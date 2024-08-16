package com.dflch.pagingdemo.data.response

import com.dflch.pagingdemo.presentation.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("image") val image: String
) {
    fun toCharacterModel(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            isAlive = status == "Alive",
            species = species,
            image = image
        )
    }
}
