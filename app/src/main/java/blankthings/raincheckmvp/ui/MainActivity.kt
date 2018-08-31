package blankthings.raincheckmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import blankthings.raincheckmvp.R
import blankthings.raincheckmvp.callback.FragmentInteractionCallback
import blankthings.raincheckmvp.net.data.Photo
import blankthings.raincheckmvp.ui.view.main.MainFragment
import blankthings.raincheckmvp.ui.view.maindetail.MainDetailFragment

class MainActivity : AppCompatActivity(), FragmentInteractionCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragmentManager()
    }

    // TODO - Remove and implement Navigation architecture component.

    private fun setupFragmentManager() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MainFragment())
                .commit()
    }

    override fun onPhotoClicked(photoSelected : Photo) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MainDetailFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun back() {
        supportFragmentManager.popBackStack()
    }

}
