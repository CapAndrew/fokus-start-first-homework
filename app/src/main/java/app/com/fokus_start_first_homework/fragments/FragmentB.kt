package app.com.fokus_start_first_homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.com.fokus_start_first_homework.R
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentB : Fragment() {

    companion object {

        fun newInstance() = FragmentB()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonNext.setOnClickListener { openFragmentC() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    private fun openFragmentC() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentC.newInstance())
            .addToBackStack(null)
            .commit()
    }

}