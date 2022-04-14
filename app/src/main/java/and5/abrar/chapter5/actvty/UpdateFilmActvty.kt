package and5.abrar.chapter5.actvty

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.model.RequestFilm
import and5.abrar.chapter5.network.ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_film_actvty.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFilmActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_film_actvty)
        val getfilm = intent.getParcelableExtra<GetAllFilmResponseItem>("update")
        upnama.setText(getfilm?.name)
        updesc.setText(getfilm?.description)
        updirector.setText(getfilm?.director)
        upimage.setText(getfilm?.image)

        btnupdate.setOnClickListener {
            val id = getfilm?.id
            val nama = upnama.text.toString()
            val desc = updesc.text.toString()
            val direc = updirector.text.toString()
            val image = upimage.text.toString()
            updateData(id!!.toInt(),nama,image,desc,direc)
            finish()
        }
    }
    fun updateData(id:Int,name:String,img:String,desc:String,director:String){
        ApiClient.instance.updateFilm(id, RequestFilm(desc,director,img,name))
            .enqueue(object : Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateFilmActvty,response.message(), Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@UpdateFilmActvty,response.message(), Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateFilmActvty,t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

}