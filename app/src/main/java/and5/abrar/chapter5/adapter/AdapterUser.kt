package and5.abrar.chapter5.adapter

import and5.abrar.chapter5.R
import and5.abrar.chapter5.model.GetAllUserItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_film.view.*
import kotlinx.android.synthetic.main.item_user.view.*

class AdapterUser(private  val listdatauser : List<GetAllUserItem>): RecyclerView.Adapter<AdapterUser.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user,parent, false)
        return AdapterUser.ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nama.text = listdatauser[position].name
        holder.itemView.adress.text = listdatauser[position].address
        holder.itemView.umur.text = listdatauser[position].umur.toString()
    }

    override fun getItemCount(): Int {
        return listdatauser.size
    }
}