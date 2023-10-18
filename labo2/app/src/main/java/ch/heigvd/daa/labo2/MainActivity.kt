package ch.heigvd.daa.labo2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.GravityCompat
import ch.heigvd.daa.labo2.databinding.ActivityMainBinding
import ch.heigvd.daa.labo2.part1.Part1MainActivity
import ch.heigvd.daa.labo2.part2.Part2MainActivity
import ch.heigvd.daa.labo2.part3.Part3MainActivity
import androidx.activity.addCallback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var githubLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    override fun onBackPressed() {
        with(binding){
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun setClickListeners(){
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

            //Nasty way to find the github link TextView in the drawer content
            githubLink = navView.getHeaderView(0).findViewById(R.id.text_view_github_link)

            // Handles the click on the github "link" in the drawer
            githubLink.setOnClickListener {
                val uri: Uri = Uri.parse("https://github.com/DrC0okie/HEIG_DAA_Labo2")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setDataAndType(uri, "text/html")

                // Check if a browser is available on the system
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }

            // Handle the info button
            imageButtonHelp.setOnClickListener {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
            }
        }
    }
}