package ch.heigvd.daa.labo2.part1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContract

class EditName : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String) =
        Intent(context, EditActivity::class.java).apply {
            putExtra(IN_NAME, input)
        }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if(resultCode != AppCompatActivity.RESULT_OK) {
            return null
        }
        return intent?.getStringExtra(OUT_NAME)
    }
    companion object {
        const val IN_NAME = "name in"
        const val OUT_NAME = "name out"
    }
}