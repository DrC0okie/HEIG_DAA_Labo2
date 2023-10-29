package ch.heigvd.daa.labo2.part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.commit
import ch.heigvd.daa.labo2.databinding.ActivityMainPart3Binding

/**
 * This activity serves as a host for multiple fragments that allow
 * the user to navigate through a multi-stage configuration process.
 * The navigation is managed using three buttons: previous, close, and next.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class Part3MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPart3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPart3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the default fragment for the first stage if no prior state is saved
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(binding.fragmentContainer.id, Part3Fragment.newInstance(1))
                addToBackStack(null)
            }
        }

        // Override the default behavior of the Android back button
        onBackPressedDispatcher.addCallback(this) { finish() }

        // Set up the listeners for the custom UI buttons
        with(binding) {
            buttonBack.setOnClickListener { onBackClicked() }
            buttonClose.setOnClickListener { onCloseClicked() }
            buttonNext.setOnClickListener { onNextClicked() }
        }
    }

    /**
     * Loads and displays the next fragment in the sequence.
     */
    private fun onNextClicked() {
        val currentBackStackCount = supportFragmentManager.backStackEntryCount
        val nextFragment = Part3Fragment.newInstance(currentBackStackCount + 1)
        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, nextFragment)
            addToBackStack(null)
        }
    }

    /**
     * Closes the activity.
     */
    private fun onCloseClicked() = finish()

    /**
     * Handles the click event of the custom back button.
     */
    private fun onBackClicked(){
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}