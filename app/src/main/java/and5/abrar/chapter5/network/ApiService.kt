package and5.abrar.chapter5.network

import and5.abrar.chapter5.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("user")
    fun getAllUser():Call<List<GetAllUserItem>>

    @POST("user")
    fun postUser(@Body req:RequestUser): Call<PostUserRespond>

    @DELETE("user/{id}")
    fun deleteUser(@Path("id") id : Int):Call<Int>

    @PUT("user/{id}")
    fun updateUser(
        @Path ("id") id : Int,
        @Body req:RequestUser
    )

    @GET("film")
    fun getAllFilm():Call<List<GetAllFilmResponseItem>>

    @POST("film")
    fun postFilm(@Body req:RequestFilm): Call<PostFilmRespond>

    @DELETE("film/{id}")
    fun deleteFilm(@Path ("id" ) id : Int):Call<Int>

    @PUT("film/{id}")
    fun updateFilm(
        @Path("id") id: Int,
        @Body req:RequestFilm
    ):Call<List<GetAllFilmResponseItem>>
}