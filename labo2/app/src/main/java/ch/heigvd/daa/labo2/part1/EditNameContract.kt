package ch.heigvd.daa.labo2.part1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContract

/**
 * A contract defining the interaction between Part1MainActivity and EditActivity.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class EditNameContract : ActivityResultContract<String, String?>() {

    /**
     * Creates an [Intent] for launching [Part1EditActivity] with a given input name.
     * @param context The context used to create the intent.
     * @param input The user's name to be passed to [Part1EditActivity] for editing.
     * @return An intent to launch [Part1EditActivity].
     */
    override fun createIntent(context: Context, input: String) =
        Intent(context, Part1EditActivity::class.java).apply {
            putExtra(KEY_INPUT_NAME, input)
        }

    /**
     * Parses the result from [Part1EditActivity] to extract the possibly edited name.
     * @param resultCode The result code returned from the launched activity.
     * @param intent The intent containing the data/result returned from the launched activity.
     * @return The edited name, or null if the result was not successful or no name was provided.
     */
    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if(resultCode != AppCompatActivity.RESULT_OK) {
            return null
        }
        return intent?.getStringExtra(KEY_OUTPUT_NAME)
    }
    companion object {
        // Key used to pass the input name to EditActivity
        const val KEY_INPUT_NAME = "key_name_input"

        // Key used to retrieve the edited name from the result of EditActivity
        const val KEY_OUTPUT_NAME = "key_name_output"
    }
}