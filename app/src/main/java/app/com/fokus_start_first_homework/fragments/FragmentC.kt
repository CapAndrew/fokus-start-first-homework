package app.com.fokus_start_first_homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import app.com.fokus_start_first_homework.R
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentC : Fragment() {

    companion object {

        fun newInstance() = FragmentC()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonNext.setOnClickListener { openFragmentA() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    private fun openFragmentA() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentA.newInstance())
            .addToBackStack(null)
            .commit()

        if (parentFragmentManager.backStackEntryCount > 0) {
            parentFragmentManager.popBackStack(
                parentFragmentManager.getBackStackEntryAt(0).id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }
}