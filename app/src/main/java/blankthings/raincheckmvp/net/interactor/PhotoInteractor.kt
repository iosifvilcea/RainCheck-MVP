package blankthings.raincheckmvp.net.interactor

import android.content.Context
import android.util.Log
import blankthings.raincheckmvp.net.data.Photo
import blankthings.raincheckmvp.net.db.PhotoDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PhotoInteractor(context: Context?) : BaseInteractor() {

    val TAG = PhotoInteractor::class.java.name

    lateinit var photoDao: PhotoDao

    lateinit var photos : List<Photo>

    init {
        if (context != null) {
            photoDao = DbInteractor(context).getPhotoDao()
        }
    }


    fun getPhotoById(photoId : Int) : Photo {
        for (photo in photos) {
            if (photo.id == photoId) {
                return photo
            }
        }

        return Photo(0, 0, "No Photo Available", "N/A", "N/A")
    }


    fun savePhotosToDb(photos: List<Photo>) {
        if (photos.isEmpty())
            return

        Observable.fromCallable { photoDao.insertAllPhotos(photos) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { Log.d(TAG, "Saving ${photos.size} photos from API to DB...") }
    }


    fun getPhotosFromDb() : Observable<List<Photo>> {
        return photoDao.getPhotos()
                .filter { it.isNotEmpty() }
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext({
                    Log.d(PhotoInteractor::class.java.name, "Dispatching ${it.size} users from DB...")
                })
    }


    fun getPhotosFromApi() : Observable<List<Photo>> {
        return apiService.getPhotos()
                .subscribeOn(Schedulers.io())
                .doOnNext { savePhotosToDb(it) }
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getPhotos() : Observable<List<Photo>> {
        return Observable.concatArray(getPhotosFromDb(), getPhotosFromApi())
    }

}