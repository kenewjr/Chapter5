package and5.abrar.chapter5

import and5.abrar.chapter5.actvty.AddFilmActvty
import and5.abrar.chapter5.actvty.DetailFilm
import and5.abrar.chapter5.adapter.AdapterFilm
import and5.abrar.chapter5.adapter.AdapterUser
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.model.GetAllUserItem
import and5.abrar.chapter5.network.ApiClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdatafilm()
        addfilm.setOnClickListener {
            val mindah =Intent(this,AddFilmActvty::class.java)
            startActivity(mindah)
        }
//        getdatauser()
    }
    fun getdatafilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>
            {
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val datafilm = response.body()
                        val adapterFilm = AdapterFilm(datafilm!!){
                            val pindah = Intent(this@MainActivity,DetailFilm::class.java)
                            pindah.putExtra("detail", it)
                            startActivity(pindah)
                        }
                        val lm = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                        rvFilm.layoutManager=lm
                        rvFilm.adapter = adapterFilm

                    }else{
                        Toast.makeText(this@MainActivity,response.message(),Toast.LENGTH_LONG).show()
                    }


                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
                }
            }

            )
    }
    fun getdatauser(){
        ApiClient.instance.getAllUser()
            .enqueue(object : retrofit2.Callback<List<GetAllUserItem>>
            {
                override fun onResponse(
                    call: Call<List<GetAllUserItem>>,
                    response: Response<List<GetAllUserItem>>
                ) {
                    if (response.isSuccessful){
                        val datauser = response.body()
                        val adapterFilm = AdapterUser(datauser!!)
                        val lm = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                        rvFilm.layoutManager=lm
                        rvFilm.adapter = adapterFilm

                    }else{
                        Toast.makeText(this@MainActivity,response.message(),Toast.LENGTH_LONG).show()
                    }


                }

                override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
                }
            }

            )
    }

    override fun onResume() {
        super.onResume()
        getdatafilm()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}