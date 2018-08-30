package blankthings.raincheckmvp.ui.view.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blankthings.raincheckmvp.R
import blankthings.raincheckmvp.net.data.Photo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_card_photo.view.*

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun inflateView(parent: ViewGroup) : PhotoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_card_photo, parent, false)
            return PhotoViewHolder(view)
        }
    }

    fun bind(photo: Photo, position : Int, clickListener : (Int) -> Unit) {
        itemView.title.text = photo.title
        itemView.url.text = photo.url

        Glide.with(itemView.context)
                .load(photo.thumbnailUrl)
                .into(itemView.thumbnail)

        itemView.setOnClickListener({ clickListener(position) })
    }

}