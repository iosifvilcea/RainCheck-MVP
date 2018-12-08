package blankthings.raincheckmvp.ui.presenter

import android.annotation.SuppressLint
import android.util.Log
import blankthings.raincheckmvp.net.interactor.PhotoInteractor
import blankthings.raincheckmvp.ui.view.main.MainView

class MainPresenter(private var mainView : MainView?, private val photoInteractor: PhotoInteractor) {

    fun init() {
        fetchPhotos()
    }

    fun teardown() {
        mainView = null
    }

    fun onItemClicked(itemPosition : Int) {
        mainView?.onPhotoSelected(photoInteractor.getPhotoById(itemPosition))
    }

    @SuppressLint("CheckResult")
    private fun fetchPhotos() {
        photoInteractor.getPhotos()
                .subscribe({
                    mainView?.addPhotos(it)
                }, {
                    it.printStackTrace()
                })
    }

}