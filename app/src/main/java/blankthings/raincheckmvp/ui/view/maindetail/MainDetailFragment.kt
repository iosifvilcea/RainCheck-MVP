package blankthings.raincheckmvp.ui.view.maindetail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blankthings.raincheckmvp.R
import blankthings.raincheckmvp.callback.FragmentInteractionCallback
import blankthings.raincheckmvp.net.data.Photo
import blankthings.raincheckmvp.net.interactor.PhotoInteractor
import blankthings.raincheckmvp.ui.presenter.MainDetailPresenter
import kotlinx.android.synthetic.main.fragment_main_detail.*

class MainDetailFragment : Fragment(), MainDetailView {

    lateinit var presenter: MainDetailPresenter
    lateinit var interactionCallback : FragmentInteractionCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentInteractionCallback) {
            interactionCallback = context
        } else {
            throw IllegalStateException("Parent activity needs to implement FragmentInteractionCallback")
        }
    }

    private fun setupPresenter() {
        presenter = MainDetailPresenter(this, PhotoInteractor(context))
    }

    override fun showPhoto(photo: Photo) {
        title.text = photo.title
        url.text = photo.url
    }

}