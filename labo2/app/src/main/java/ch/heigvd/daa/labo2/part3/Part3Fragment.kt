package ch.heigvd.daa.labo2.part3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.daa.labo2.R

/**
 * A fragment representing a single stage in the configuration process.
 * Displays the current stage number to the user.
 * @author Anthony David, Felix Breval, Timothée Van Hove
 */
class Part3Fragment : Fragment() {

    private var fragmentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the fragment number from the arguments
        arguments?.let { fragmentNumber = it.getInt(ARG_FRAG_NBR) }
    }

    /**
     * Inflates the fragment's UI layout.
     * @return The root view of the fragment's layout.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_part3, container, false)
    }

    /**
     * Sets up the UI elements once the view is created. Specifically,
     * it updates the TextView to display the current fragment number.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contentText = view.findViewById<TextView>(R.id.text_view_content)
        contentText.text = getString(R.string.fragment_number, fragmentNumber)
    }

    companion object {
        private const val ARG_FRAG_NBR = "step"

        /**
         * Factory method to create a new instance of the fragment.
         * @param step The stage number for this fragment.
         * @return A new instance of Part3Fragment.
         */
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