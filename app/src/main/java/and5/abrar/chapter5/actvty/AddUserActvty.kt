package and5.abrar.chapter5.actvty

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.PostFilmRespond
import and5.abrar.chapter5.model.PostUserRespond
import and5.abrar.chapter5.model.RequestFilm
import and5.abrar.chapter5.model.RequestUser
import and5.abrar.chapter5.network.ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUserActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user_actvty)
    }
    fun postDataUser(name :String, address:String, umur:Int,image:String){
        ApiClient.instance.postUser(RequestUser(address,image,name,umur))
            .enqueue(object : Callback<PostUserRespond> {
                override fun onResponse(
                    call: Call<PostUserRespond>,
                    response: Response<PostUserRespond>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(this@AddUserActvty,response.message(), Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddUserActvty,response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<PostUserRespond>, t: Throwable) {
                    Toast.makeText(this@AddUserActvty,t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}