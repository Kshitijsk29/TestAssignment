package com.nextin.testassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextin.testassignment.R
import com.nextin.testassignment.adapters.ExploreViewAdapter
import com.nextin.testassignment.models.UsersData
import java.util.Arrays

class ExploreFragment : Fragment() {

    private lateinit var adapter: ExploreViewAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var userDetails  : ArrayList<UsersData>

     lateinit var usersName : Array<String>
     lateinit var userLocation : Array<String>
     lateinit var userProfession : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.mainExploreRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ExploreViewAdapter(userDetails)
        recyclerView.adapter = adapter

    }

   private fun usersData(){
        userDetails = arrayListOf<UsersData>()

        usersName = arrayOf(
            "Kshitij Raypale",
            "Kunal Mittal",
            "Prasanna Deoghare",
            "harshad Gurnule",
            "Radha Kapoor"
        )

        userLocation = arrayOf(
            "Chandrapur",
            "Pune",
            "Hyderabad",
            "Mumbai",
            "Nagpur"
        )

        userProfession = arrayOf(
            "Student",
            "Java Developer",
            "Front-End Developer",
            "Student",
            "Graduated"
        )

        for (i in usersName.indices){
            val user = UsersData(usersName[i], userLocation[i],userProfession[i])
            userDetails.add(user)
        }
    }

}