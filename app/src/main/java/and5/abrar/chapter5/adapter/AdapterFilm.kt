package and5.abrar.chapter5.adapter

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.GetAllFilmResponseItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_film.view.*


class AdapterFilm(private  val listdatafilm : List<GetAllFilmResponseItem>):RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.judulFilm.text = listdatafilm[position].name
        holder.itemView.tanggalFilm.text = listdatafilm[position].date
        holder.itemView.sutradara.text = listdatafilm[position].director

    }

    override fun getItemCount(): Int {
        return listdatafilm.size
    }
}