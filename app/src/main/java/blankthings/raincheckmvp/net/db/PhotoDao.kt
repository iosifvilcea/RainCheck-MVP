package blankthings.raincheckmvp.net.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import blankthings.raincheckmvp.net.data.Photo
import io.reactivex.Flowable

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo")
    fun getPhotos() : Flowable<List<Photo>>

    @Query("SELECT * FROM Photo WHERE id = :photoId")
    fun getPhotosById(photoId : Int) : Flowable<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo : Photo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPhotos(photos: List<Photo>)

}