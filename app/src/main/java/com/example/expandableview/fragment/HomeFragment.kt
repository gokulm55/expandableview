package com.example.expandableview.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expandableview.R
import com.example.expandableview.Versions
import com.example.expandableview.VersionsAdapter


class HomeFragment : Fragment(){

    lateinit var recyleview : RecyclerView
    val versionList =ArrayList<Versions>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        recyleview = view.findViewById<RecyclerView>(R.id.recycleview)
        initdata()
        setRecycleview()

        return view


    }

    private fun setRecycleview()
    {
        val versionAdapter=VersionsAdapter(versionList)
        recyleview.adapter=versionAdapter
        recyleview.setHasFixedSize(true)

    }

    private fun initdata()
    {
        versionList.clear()
        versionList.add(
                Versions(
                        "android  10",
                        "Version 10",
                        "Api 29",
                        "Wellcome")
        )
        versionList.add(Versions(
                "pie",
                "12",
                "29",
                "wellcome"
        ))

    }


}