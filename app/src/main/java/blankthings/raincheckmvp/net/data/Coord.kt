package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lat")
    var lat: Double = 0.toDouble()

    @SerializedName("lon")
    var lon: Double = 0.toDouble()

}
