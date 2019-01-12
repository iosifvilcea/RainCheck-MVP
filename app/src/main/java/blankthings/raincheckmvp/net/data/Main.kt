package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    var temp: Double = 0.0

    @SerializedName("temp_min")
    var tempMin: Double = 0.0

    @SerializedName("temp_max")
    var tempMax: Double = 0.0

    @SerializedName("pressure")
    var pressure: Double = 0.0

    @SerializedName("sea_level")
    var seaLevel: Double = 0.0

    @SerializedName("grnd_level")
    var grndLevel: Double = 0.0

    @SerializedName("humidity")
    var humidity: Double = 0.0

    @SerializedName("temp_kf")
    var tempKf: Double = 0.0

}
