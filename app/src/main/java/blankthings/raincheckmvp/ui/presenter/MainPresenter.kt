package blankthings.raincheckmvp.ui.presenter

import blankthings.raincheckmvp.net.interactor.PhotoInteractor
import blankthings.raincheckmvp.ui.view.main.MainView

class MainPresenter(private var mainView : MainView?, private val photoInteractor: PhotoInteractor) {

    fun init() {
        mainView?.addPhotos(photoInteractor.mockPhotos())
        fetchPhotos()
    }

    fun teardown() {
        mainView = null
    }

    fun onItemClicked(itemPosition : Int) {
        mainView?.onPhotoSelected(photoInteractor.getPhotoById(itemPosition))
    }

    private fun fetchPhotos() {
        photoInteractor.getPhotos()
                .subscribe({
                    mainView?.addPhotos(it)
                }, {
                    it.printStackTrace()
                })
    }

}