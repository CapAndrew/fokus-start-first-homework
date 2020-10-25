package app.com.fokus_start_first_homework.contact_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.com.fokus_start_first_homework.R

class ContactsAdapter(context: Context, contactsList: MutableList<ContactItem>) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {
    private val context: Context = context
    private val contactsList: MutableList<ContactItem> = contactsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactItem: ContactItem = contactsList[position]
        val contactName: String? = contactItem.name
        val contactPhone: String? = contactItem.phone

        holder.contactName.text = contactName
        holder.contactPhone.text = contactPhone
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactName: TextView = itemView.findViewById(R.id.contact_name)
        var contactPhone: TextView = itemView.findViewById(R.id.contact_phone)
    }

}
