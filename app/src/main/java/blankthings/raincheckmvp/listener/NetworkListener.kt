package blankthings.raincheckmvp.listener

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

internal class NetworkListener(
        private val context: Context,
        private val callback: (Boolean) -> Unit) {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun checkNetworkConnection() {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        callback(activeNetwork?.isConnectedOrConnecting == true)
    }

}
