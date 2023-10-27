package ch.heigvd.daa.labo2.part1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.daa.labo2.R
import androidx.appcompat.widget.AppCompatTextView

class Part1MainActivity : AppCompatActivity() {

    private val ARG_NAME = "name"

    private var name: String = ""

    private lateinit var welcomeMessage: AppCompatTextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NAME, name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        name = savedInstanceState.getString(ARG_NAME, "")
        updateInterface()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_part1) // Set the layout

        val editButton = findViewById<Button>(R.id.button_edit_name) // Initialize editButton
        welcomeMessage = findViewById<AppCompatTextView>(R.id.text_view_welcome_message) // Initialize welcomeMessage

        editButton.setOnClickListener {
            editName.launch(name)
        }

        updateInterface()
    }

    private val editName = registerForActivityResult(EditName()) { newName ->
        newName?.let {
            name = it
        }
        updateInterface()
    }

    fun updateInterface() {
        if (name.isEmpty())
            welcomeMessage.setText(R.string.main_welcome_message_anonymous)
        else
            welcomeMessage.text = getString(R.string.main_welcome_message, name)
    }
}

