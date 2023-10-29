package ch.heigvd.daa.labo2.part1

import android.os.Bundle
import ch.heigvd.daa.labo2.R
import ch.heigvd.daa.labo2.databinding.ActivityMainPart1Binding

/**
 * This activity serves as the main entry point of part 1 of the application.
 * It displays a welcome message to the user, allowing them to edit their name.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class Part1MainActivity : Part1BaseActivity() {

    companion object {
        // Key used to store and retrieve the 'name' from saved state bundle
        private const val ARG_NAME = "name"
    }

    // Holds the user's name which is displayed in the welcome message
    private var name = ""

    // Binding object instance
    private lateinit var binding: ActivityMainPart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPart1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the button's click listener to launch the EditNameContract
        binding.buttonEditName.setOnClickListener {
            editNameContract.launch(name)
        }

        updateInterface()
    }

    // ActivityResultContract instance to handle the result from the EditActivity
    private val editNameContract = registerForActivityResult(EditNameContract()) { newName ->
        newName?.let { name = it }
        updateInterface()
    }

    /**
     * Updates the welcome message displayed to the user.
     */
    private fun updateInterface() {
        binding.textViewWelcomeMessage.text =
            if (name.isEmpty()) getString(R.string.main_welcome_message_anonymous)
            else getString(R.string.main_welcome_message, name)
    }

    /**
     * Saves the user's name to the bundle just before the activity is destroyed.
     * This ensures that the name is preserved across configuration changes.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NAME, name)
    }

    /**
     * Restores the user's name from the bundle after the activity is recreated.
     * This ensures that the name remains consistent across configuration changes.
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        name = savedInstanceState.getString(ARG_NAME, "")
        updateInterface()
    }
}
