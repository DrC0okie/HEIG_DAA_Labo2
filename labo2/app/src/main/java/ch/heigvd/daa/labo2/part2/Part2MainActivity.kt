package ch.heigvd.daa.labo2.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.heigvd.daa.labo2.R

/**
 * This activity serves as a container for two provided fragments.
 * The screen is divided into two sections, with each fragment occupying one of them.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class Part2MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_part2)
    }
}