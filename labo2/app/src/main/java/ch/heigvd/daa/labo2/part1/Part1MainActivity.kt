package ch.heigvd.daa.labo2.part1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.daa.labo2.R

class Part1MainActivity : AppCompatActivity() {

    private val NAME_PARAM = "name"

    private var name: String = ""

    val welcomeMessage = findViewById<androidx.appcompat.widget.AppCompatTextView>(R.id.text_view_welcome_message)

    val editButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button_edit_name)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME_PARAM, name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        name = savedInstanceState.getString(NAME_PARAM, "")
        updateInterface()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editButton.setOnClickListener {
            editName.launch(name)
        }
        updateInterface()
    }

    private val editName = registerForActivityResult(EditName()) { newName ->
        newName?.let{
            name = it
        }
        updateInterface()
    }

    fun updateInterface() {
        if(name.isEmpty())
            welcomeMessage.setText(R.string.main_welcome_message_anonymous)
        else
            welcomeMessage.setText(getString(R.string.main_welcome_message, name))
    }

}