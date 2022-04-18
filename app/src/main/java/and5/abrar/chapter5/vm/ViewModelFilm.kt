package and5.abrar.chapter5.vm

import and5.abrar.chapter5.actvty.DetailFilm
import and5.abrar.chapter5.adapter.AdapterFilm
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.network.ApiClient
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class ViewModelFilm:ViewModel() {
    lateinit var  livedatafilm :MutableLiveData<List<GetAllFilmResponseItem>>

    init {
        livedatafilm = MutableLiveData()
    }
    fun getLiveFilmObserver() : MutableLiveData<List<GetAllFilmResponseItem>>{
        return  livedatafilm
    }
    fun makeApiFilm() {
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>
            {
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                            livedatafilm.postValue(response.body())
                    }else{
                       livedatafilm.postValue(null)
                    }
                }
                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    livedatafilm.postValue(null)
                }
            }
            )
    }
}