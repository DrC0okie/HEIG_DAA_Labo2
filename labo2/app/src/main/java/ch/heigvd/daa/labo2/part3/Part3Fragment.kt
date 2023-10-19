package ch.heigvd.daa.labo2.part3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.daa.labo2.R

class Part3Fragment : Fragment() {

    private var fragmentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fragmentNumber = it.getInt(ARG_FRAG_NBR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_part3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contentText = view.findViewById<TextView>(R.id.text_view_content)
        contentText.text = getString(R.string.fragment_number, fragmentNumber)
    }

    companion object {
        private const val ARG_FRAG_NBR = "step"

        @JvmStatic
        fun newInstance(step: Int): Part3Fragment {
            val fragment = Part3Fragment()
            val args = Bundle().apply {
                putInt(ARG_FRAG_NBR, step)
            }
            fragment.arguments = args
            return fragment
        }
    }
}