package and5.abrar.chapter5.actvty

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import and5.abrar.chapter5.network.ApiClient
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import kotlinx.android.synthetic.main.item_film.*
import kotlinx.android.synthetic.main.item_film.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val detailFilm = intent.getParcelableExtra<GetAllFilmResponseItem>("detail")

        tvJudul.text = detailFilm?.name
        tglFilm.text = detailFilm?.date
        tvsutradara.text = detailFilm?.director
        Glide.with(this)
            .load(detailFilm?.image)
            .into(imgdetail)
        btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("hapusdata")
                .setMessage("yakin hapus data?")
                .setPositiveButton("ya"){ dialogInterface: DialogInterface, i: Int ->
                    deleteFilm(detailFilm?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()
        }
        btnupdate.setOnClickListener {
            val pindah = Intent(this,UpdateFilmActvty::class.java)
            pindah.putExtra("update",detailFilm)
            startActivity(pindah)
        }
    }
    fun deleteFilm(id : Int){
        ApiClient.instance.deleteFilm(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailFilm,response.message(), Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@DetailFilm,response.message(), Toast.LENGTH_LONG).show()
                    }

                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailFilm,t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}