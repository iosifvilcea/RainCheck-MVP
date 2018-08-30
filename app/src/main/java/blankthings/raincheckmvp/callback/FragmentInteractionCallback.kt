package blankthings.raincheckmvp.callback

import blankthings.raincheckmvp.net.data.Photo

interface FragmentInteractionCallback {

    fun onPhotoClicked(photoSelected : Photo)

    fun back()

}