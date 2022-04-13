package and5.abrar.chapter5.actvty

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.PostFilmRespond
import and5.abrar.chapter5.model.RequestFilm
import and5.abrar.chapter5.network.ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_film_actvty.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFilmActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_film_actvty)
        btntambah.setOnClickListener {
            val name = addnama.text.toString()
            val gambar = addimage.text.toString()
            val director = adddirector.text.toString()
            val desc = adddesc.text.toString()
            postDataFilm(desc,director,gambar,name)
            finish()
        }
    }
    fun postDataFilm(desc : String, direct : String, img: String, name : String){
        ApiClient.instance.postFilm(RequestFilm(desc,direct,img,name))
            .enqueue(object : Callback<PostFilmRespond>{
                override fun onResponse(
                    call: Call<PostFilmRespond>,
                    response: Response<PostFilmRespond>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(this@AddFilmActvty,response.message(),Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddFilmActvty,response.message(),Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<PostFilmRespond>, t: Throwable) {
                    Toast.makeText(this@AddFilmActvty,t.message,Toast.LENGTH_LONG).show()
                }

            })
    }
}