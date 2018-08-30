package blankthings.raincheckmvp.ui.view.main

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
import blankthings.raincheckmvp.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainView {

    lateinit var presenter: MainPresenter
    lateinit var interactionCallback : FragmentInteractionCallback
    lateinit var adapter : MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
        setupRecyclerView()
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
        presenter = MainPresenter(this, PhotoInteractor(context))
    }

    private fun setupRecyclerView() {
        adapter = MainAdapter { presenter.onItemClicked(it) }
        mainRecyclerView.adapter = adapter
        mainRecyclerView.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()
        presenter.init()
    }

    override fun onStop() {
        super.onStop()
        presenter.teardown()
    }

    override fun addPhotos(photos: List<Photo>) {
        adapter.setPhotos(photos)
    }

    override fun onPhotoSelected(photoSelected: Photo) {
        interactionCallback.onPhotoClicked(photoSelected)
    }

}