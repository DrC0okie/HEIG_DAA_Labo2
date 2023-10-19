package ch.heigvd.daa.labo2.part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.core.view.GravityCompat
import androidx.fragment.app.commit
import ch.heigvd.daa.labo2.R
import ch.heigvd.daa.labo2.databinding.ActivityMainPart3Binding

class Part3MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPart3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPart3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container, Part3Fragment.newInstance(1))
                addToBackStack(null)
            }
        }

        // Handle the back button if only one fragment is in the back stack
        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            } else {
                finish()
            }
        }

        with(binding) {
            buttonBack.setOnClickListener { onBackClicked() }
            buttonClose.setOnClickListener { onCloseClicked() }
            buttonNext.setOnClickListener { onNextClicked() }
        }
    }

    private fun onNextClicked() {
        val currentBackStackCount = supportFragmentManager.backStackEntryCount
        val nextFragment = Part3Fragment.newInstance(currentBackStackCount + 1)
        supportFragmentManager.commit {
            replace(R.id.fragment_container, nextFragment)
            addToBackStack(null)
        }
    }

    private fun onCloseClicked() = finish()

    private fun onBackClicked() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}