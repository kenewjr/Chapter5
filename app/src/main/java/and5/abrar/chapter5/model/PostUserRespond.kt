package and5.abrar.chapter5.model


import com.google.gson.annotations.SerializedName

data class PostUserRespond(
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("umur")
    val umur: Int
)