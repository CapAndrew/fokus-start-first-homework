package app.com.fokus_start_first_homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import app.com.fokus_start_first_homework.R
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    companion object {

        fun newInstance() = FragmentA()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonNext.setOnClickListener { openFragmentB() }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    private fun openFragmentB() {
       parentFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentB.newInstance())
            .commit()
    }
}