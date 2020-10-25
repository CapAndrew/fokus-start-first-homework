package app.com.fokus_start_first_homework.contact_list

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.com.fokus_start_first_homework.R
import kotlinx.android.synthetic.main.contacts_fragment.*

class ContactsFragment() : Fragment() {

    companion object {
        fun newInstance() = ContactsFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)

        val contactsList: MutableList<ContactItem> = getContacts()


        val contactAdapter = ContactsAdapter(context!!, contactsList)
        recycler_view.adapter = contactAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.contacts_fragment, container, false)
    }

    private fun getContacts(): MutableList<ContactItem> {


        val contactsList: MutableList<ContactItem> = ArrayList()
        val contentResolver = context?.contentResolver
        val cursor = contentResolver?.query(
            Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getLong(cursor.getColumnIndex(Phone._ID))
                val displayName = it.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME))
                val phone = it.getString(cursor.getColumnIndex(Phone.NUMBER))
                contactsList.add(ContactItem(displayName, phone))
            }
        } ?: return contactsList
        return contactsList
    }


}