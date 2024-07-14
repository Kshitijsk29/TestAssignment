package com.nextin.testassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nextin.testassignment.R
import com.nextin.testassignment.models.UsersData

class ExploreViewAdapter (private val arrayList:ArrayList<UsersData>):RecyclerView.Adapter<ExploreViewAdapter.MyViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.
        from(parent.context).inflate(R.layout.each_item_view,parent,false)

        return  MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = arrayList[position]
        holder.uname.text = currentUser.userName
        holder.location.text = currentUser.userLocation
        holder.proffession.text = currentUser.userProfession
    }

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val uname = itemView.findViewById<TextView>(R.id.username)
        val location = itemView.findViewById<TextView>(R.id.userLocation)
        val proffession = itemView.findViewById<TextView>(R.id.userProfession)
    }
}