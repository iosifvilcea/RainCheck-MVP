package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("speed")
    var speed: Double = 0.toDouble()

    @SerializedName("deg")
    var deg: Int = 0

}
