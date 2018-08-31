package blankthings.raincheckmvp.net.interactor

import android.content.Context
import blankthings.raincheckmvp.net.data.Photo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PhotoInteractor(context: Context?) : BaseInteractor() {

//    private var photoDao: PhotoDao = DbInteractor(context).getPhotoDao()

    lateinit var photos : List<Photo>

    init {
        mockPhotos()
    }

    fun mockPhotos() : List<Photo> {
        val url = "http://www.startlr.com/wp-content/uploads/2017/12/FlatXoreo.png"
        val p1 = Photo(1, 1, "Al", "idk", url)
        val p2 = Photo(2, 2, "Pizza", "hut.com", url)
        val p3 = Photo(3, 3, "Koolaid", "koolaid.com", url)
        val p4 = Photo(4, 4, "Aafa", "gasd", url)
        val p5 = Photo(5, 5, "PZZZZ", "aavvv.com", url)
        val p6 = Photo(6, 6, "Kool", "kool.com", url)
        val p7 = Photo(7, 7, "Arbbby", "arrby", url)
        val p8 = Photo(8, 8, "Red", "red.com", url)
        val p9 = Photo(9, 9, "Blue", "blue.com", url)
        photos = listOf(p1,p2, p3, p4, p5, p6, p7, p8, p9)
        return photos
    }

    fun getMockedPhotos() : List<Photo> {
        return photos
    }

    fun getPhotoById(photoId : Int) : Photo {
        for (photo in photos) {
            if (photo.id == photoId) {
                return photo
            }
        }

        return Photo(0, 0, "No Photo Available", "N/A", "N/A")
    }

//    fun getPhotosFromDb() : Observable<List<Photo>> {
//        return photoDao.getPhotos().filter { it.isNotEmpty() }
//                .toObservable()
//                .doOnNext({
//                    Log.e("PhotoInteractor", "Dispatching ${it.size} users from DB...")
//                })
//    }
//
//
//    fun savePhotosToDb(photos: List<Photo>) {
//        if (photos.isEmpty())
//            return
//        photoDao.insertAllPhotos(photos)
//    }

    fun getPhotos() : Observable<List<Photo>> {
        return apiService.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}