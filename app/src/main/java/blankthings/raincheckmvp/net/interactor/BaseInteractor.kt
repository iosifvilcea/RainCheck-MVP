package blankthings.raincheckmvp.net.interactor

import blankthings.raincheckmvp.net.api.ApiService
import io.reactivex.disposables.Disposables

abstract class BaseInteractor {

    val apiService : ApiService = ApiService.create()

}
