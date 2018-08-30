package blankthings.raincheckmvp.ui.view.main

import blankthings.raincheckmvp.net.data.Photo

interface MainView {

    fun addPhotos(photos: List<Photo>)

    fun onPhotoSelected(photoSelected: Photo)

}