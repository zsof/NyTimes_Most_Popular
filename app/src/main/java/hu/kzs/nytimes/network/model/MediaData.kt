package hu.kzs.nytimes.network.model

import com.google.gson.annotations.SerializedName

data class MediaData(
    val type: String?,
    val caption: String?,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetaData>
)