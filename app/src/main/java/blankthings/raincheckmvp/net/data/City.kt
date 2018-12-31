package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class City {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("country")
    var country: String? = null

}
