package app.memerr.feature_memerr.shared.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meme(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("width")
    val width: Int,
    @Expose
    @SerializedName("height")
    val height: Int,
    @Expose
    @SerializedName("nsfw")
    val nsfw: Boolean?,
    @Expose
    @SerializedName("link")
    val link: String
)