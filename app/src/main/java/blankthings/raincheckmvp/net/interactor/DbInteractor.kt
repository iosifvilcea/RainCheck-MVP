package blankthings.raincheckmvp.net.interactor

import android.content.Context
import blankthings.raincheckmvp.net.db.AppDatabase
import blankthings.raincheckmvp.net.db.PhotoDao

class DbInteractor(context: Context) {

    private val db = AppDatabase.getInstance(context)

    fun getPhotoDao() : PhotoDao {
        return db.photoDao()
    }

}