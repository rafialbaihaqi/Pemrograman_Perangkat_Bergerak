package id.rafialbaihaqi_19104042.praktikum6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rafialbaihaqi_19104042.praktikum6.MyData
import id.rafialbaihaqi_19104042.praktikum6.R

class ListMyDataAdapter(private val listMyData: ArrayList<MyData>) :
    RecyclerView.Adapter<ListMyDataAdapter.ListViewHolder>() {
    private lateinit var tv_item_name : TextView
    private lateinit var tv_item_description : TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)


        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])
    }

    override fun getItemCount(): Int = listMyData.size
    inner class ListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(myData: MyData) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(myData.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(findViewById(R.id.img_item_photo))
                tv_item_name = findViewById(R.id.tv_item_name)
                tv_item_description = findViewById(R.id.tv_item_description)
                tv_item_name.text = myData.name
                tv_item_description.text = myData.description
            }
        }
    }
}