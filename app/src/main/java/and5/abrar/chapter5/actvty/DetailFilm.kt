package and5.abrar.chapter5.actvty

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_film.*
import kotlinx.android.synthetic.main.item_film.*
import kotlinx.android.synthetic.main.item_film.view.*

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
    }
}