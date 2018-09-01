package blankthings.raincheckmvp.net.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import blankthings.raincheckmvp.net.data.Photo

@Database(entities = [(Photo::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "app.db"
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME).build()
            }

            return instance!!
        }
    }


    abstract fun photoDao() : PhotoDao

}