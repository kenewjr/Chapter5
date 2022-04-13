package and5.abrar.chapter5.network

import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.model.GetAllUserItem
import and5.abrar.chapter5.model.PostFilmRespond
import and5.abrar.chapter5.model.RequestFilm
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("film")
    fun getAllFilm():Call<List<GetAllFilmResponseItem>>
    @GET("user")
    fun getAllUser():Call<List<GetAllUserItem>>
    @POST("film")
    fun postFilm(@Body req:RequestFilm): Call<PostFilmRespond>
}