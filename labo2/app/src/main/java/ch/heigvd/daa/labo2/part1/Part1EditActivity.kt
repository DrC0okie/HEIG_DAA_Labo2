package ch.heigvd.daa.labo2.part1

import android.content.Intent
import android.os.Bundle
import ch.heigvd.daa.labo2.databinding.ActivityEditPart1Binding

/**
 * An activity that allows the user to edit their name.
 * The current name is passed to this activity using an intent extra and is displayed in an
 * editable text field. The edited name is returned as a result to the calling activity.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class EditActivity : Part1BaseActivity() {

    private lateinit var binding: ActivityEditPart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityEditPart1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the input name from the intent and display it in the editText
        val inName = intent?.getStringExtra(EditNameContract.KEY_INPUT_NAME)
        binding.editTextName.setText(inName ?: "")

        // Set up the click listener for the save button
        binding.buttonSave.setOnClickListener {
            val newName = binding.editTextName.text.toString()

            // Create an intent to hold the edited name as its result
            val intent = Intent().putExtra(EditNameContract.KEY_OUTPUT_NAME, newName)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}