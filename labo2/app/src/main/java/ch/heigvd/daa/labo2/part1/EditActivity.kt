package ch.heigvd.daa.labo2.part1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.daa.labo2.R

class EditActivity: AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_part1)
        val inName = intent?.getStringExtra(EditName.IN_NAME)
        val saveButton = findViewById<Button>(R.id.button_save)
        val nameEditor = findViewById<EditText>(R.id.edit_text_name)

        if (!inName.isNullOrEmpty()) {
            nameEditor.setText(inName)
        }

        saveButton.setOnClickListener {
            val name = nameEditor.text.toString()
            val intent = Intent().apply {
                putExtra(EditName.OUT_NAME, name)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}