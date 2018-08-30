package blankthings.raincheckmvp.ui.presenter

import blankthings.raincheckmvp.net.interactor.PhotoInteractor
import blankthings.raincheckmvp.ui.view.maindetail.MainDetailView

class MainDetailPresenter(private var mainDetailView: MainDetailView?, private val photoInteractor: PhotoInteractor) {

    fun init() {
    }

    fun showPhoto(photoId : Int) {
        mainDetailView?.showPhoto(photoInteractor.getPhotoById(1))
    }

    fun teardown() {
        mainDetailView = null
    }

}