package com.example.expandableview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

//lateinit var downimage:ImageView

class VersionsAdapter(val versionList: List<Versions>) : RecyclerView.Adapter<VersionsAdapter.Versioncls>()
{

    class Versioncls(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var code :TextView = itemView.findViewById(R.id.codename)
        var ver:TextView=itemView.findViewById(R.id.version)
        var apilevel:TextView=itemView.findViewById(R.id.api_level)
        var description:TextView=itemView.findViewById(R.id.description)
        var linearLayout:LinearLayout=itemView.findViewById(R.id.linearlayout)
        var expandableLayout:RelativeLayout=itemView.findViewById(R.id.relative)

        var linearLayout1:LinearLayout=itemView.findViewById(R.id.linearlayout1)
        var visbilelayout:LinearLayout=itemView.findViewById(R.id.visiblelinear)
       // var relative1:RelativeLayout=itemView.findViewById(R.id.relative)

        //var linear1:LinearLayout=itemView.findViewById(R.id.linear1)

     //  var downimage:ImageView=itemView.findViewById(R.id.downimg)
//        var upimage:ImageView=itemView.findViewById(R.id.upimg)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionsAdapter.Versioncls {
        val  view:View=LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return Versioncls(view)
    }
    override fun getItemCount(): Int {
       return versionList.size
    }

    override fun onBindViewHolder(holder: Versioncls, position: Int)
    {

        holder.itemView.getContext()
        val versions : Versions =versionList[position]
        holder.code.text=versions.codeName
        holder.ver.text=versions.version
        holder.apilevel.text=versions.appLevel
        holder.description.text=versions.description

        val isExpandable : Boolean = versionList[position].expandable
        holder.expandableLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE
        holder.linearLayout.setOnClickListener {
           Log.e("layout", "+++++++++++++++++++++++++")
//
          val vers =versionList[position]
            vers.expandable = !versions.expandable
            notifyItemChanged(position)
            if (isExpandable) {
                val img: ImageView = holder.itemView.findViewById(R.id.downimg)
                img.setImageResource(R.drawable.ic_arrow_up_24);
           }
            else {
              val img: ImageView = holder.itemView.findViewById(R.id.downimg)
            img.setImageResource(R.drawable.ic_arrow_down_24);
           }

            }

        holder.linearLayout1.setOnClickListener {
            holder.visbilelayout.isVisible
            val vers =versionList[position]
            vers.expandable = !versions.expandable
            notifyItemChanged(position)
        }


    }

}