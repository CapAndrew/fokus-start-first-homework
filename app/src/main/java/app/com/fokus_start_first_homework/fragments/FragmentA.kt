package app.com.fokus_start_first_homework.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import app.com.fokus_start_first_homework.R
import app.com.fokus_start_first_homework.contact_list.ContactsFragment
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    companion object {

        fun newInstance() = FragmentA()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonNext.setOnClickListener { openFragmentB() }
        openContacts.setOnClickListener { openContacts() }

        if (!checkContactsPermission()) {
            askPermission(Manifest.permission.READ_CONTACTS)
        } else {
            openContacts.isEnabled = true
        }

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
            .addToBackStack(null)
            .commit()
    }

    private fun openContacts() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, ContactsFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun askPermission(vararg permissions: String) {
        requestPermissions(permissions, 0)
    }

    private fun checkContactsPermission(): Boolean {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(
            context!!,
            Manifest.permission.READ_CONTACTS
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        openContacts.isEnabled = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
    }
}