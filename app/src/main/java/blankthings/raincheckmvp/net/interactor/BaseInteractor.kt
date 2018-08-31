package blankthings.raincheckmvp.net.interactor

import blankthings.raincheckmvp.net.api.ApiService

abstract class BaseInteractor {

    val apiService : ApiService = ApiService.create()

}