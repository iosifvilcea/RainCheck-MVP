package blankthings.raincheckmvp.ui.view.main

import blankthings.raincheckmvp.net.data.Photo

interface MainView {

    fun addPhotos(photos: List<Photo>)

    fun showError(error: String?)

    fun onPhotoSelected(photoSelected: Photo)

}