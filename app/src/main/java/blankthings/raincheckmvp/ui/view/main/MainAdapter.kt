package blankthings.raincheckmvp.ui.view.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import blankthings.raincheckmvp.net.data.Photo

class MainAdapter( private val listener: (Int) -> Unit) : RecyclerView.Adapter<PhotoViewHolder>() {

    private var photos : List<Photo> = ArrayList()

    fun setPhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.inflateView(parent)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position], position, listener)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

}