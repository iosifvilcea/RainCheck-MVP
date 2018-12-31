package blankthings.raincheckmvp.net.interactor

import android.content.Context
import android.util.Log
import blankthings.raincheckmvp.net.data.Photo
import blankthings.raincheckmvp.net.db.PhotoDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class PhotoInteractor(context: Context?) : BaseInteractor() {

    private var lastFetch : Long = 0
    private var photos : List<Photo> = ArrayList()
    private lateinit var photoDao: PhotoDao

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
                .subscribe()
    }


    fun getPhotosFromDb() : Observable<List<Photo>> {
        return photoDao.getPhotos()
                .filter { it.isNotEmpty() }
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getPhotosFromApi() : Observable<List<Photo>> {
        return apiService.getPhotos()
                .subscribeOn(Schedulers.io())
                .doOnNext { savePhotosToDb(it) }
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getPhotos() : Observable<List<Photo>> {
        if (!isNewDataFetchAllowed()) {
            return getPhotosFromDb()
        }

        lastFetch = System.currentTimeMillis()
        return Observable.concatArray(getPhotosFromDb(), getPhotosFromApi())
    }

    fun getForecast() {
        apiService.get5DayForecast("60601")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val result = it
                    Log.e("PhotoInteractor", "wegood.")
                }, {
                    Log.e("PhotoInteractor", "Error.", it)
                })
    }


    /**
     * OpenWeatherMap APIs limit us to fetch the weather every 1 minute to prevent
     * excessive API calls. This ensures that we only remotely fetch this data if 1 minute has elapsed.
     */
    private fun isNewDataFetchAllowed() : Boolean {
        val timeDifference = System.currentTimeMillis() - lastFetch
        return timeDifference > TimeUnit.MINUTES.toMillis(1)
    }

}