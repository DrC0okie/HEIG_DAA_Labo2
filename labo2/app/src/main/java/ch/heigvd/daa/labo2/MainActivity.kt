package ch.heigvd.daa.labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.heigvd.daa.labo2.databinding.ActivityMainBinding
import ch.heigvd.daa.labo2.part1.Part1MainActivity
import ch.heigvd.daa.labo2.part2.Part2MainActivity
import ch.heigvd.daa.labo2.part3.Part3MainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            buttonPart1.setOnClickListener {
                startActivity(Intent(this@MainActivity, Part1MainActivity::class.java))
            }

            buttonPart2.setOnClickListener {
                startActivity(Intent(this@MainActivity, Part2MainActivity::class.java))
            }

            buttonPart3.setOnClickListener {
                startActivity(Intent(this@MainActivity, Part3MainActivity::class.java))
            }
        }
    }
}