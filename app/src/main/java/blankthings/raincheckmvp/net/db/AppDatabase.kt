package blankthings.raincheckmvp.net.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import blankthings.raincheckmvp.net.data.Photo

@Database(entities = arrayOf(Photo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context, AppDatabase::class.java, "app.db").build()
            }

            return instance!!
        }
    }


    abstract fun photoDao() : PhotoDao

}