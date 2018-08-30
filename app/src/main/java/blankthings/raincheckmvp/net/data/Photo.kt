package blankthings.raincheckmvp.net.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Photo(@PrimaryKey var id : Int,
                 @ColumnInfo(name = "album_id") var albumId : Int,
                 @ColumnInfo(name = "title") var title : String,
                 @ColumnInfo(name = "url") var url : String,
                 @ColumnInfo(name = "thumbnail_url") var thumbnailUrl : String)