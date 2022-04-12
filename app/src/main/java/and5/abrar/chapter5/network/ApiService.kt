package and5.abrar.chapter5.network

import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("film")
    fun getAllFilm():Call<List<GetAllFilmResponseItem>>
    @GET("user")
    fun getAllUser():Call<List<GetAllUserItem>>
}