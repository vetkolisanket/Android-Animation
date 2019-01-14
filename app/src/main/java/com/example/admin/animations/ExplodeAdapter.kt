package com.example.admin.animations

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_item_explode.view.*

/**
 * Created by Sanket on 14/01/19.
 */
class ExplodeAdapter(var itemList: List<String>, val callback: Callback): RecyclerView.Adapter<ExplodeAdapter.ExplodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplodeViewHolder {
        return ExplodeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_explode, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ExplodeViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class ExplodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { callback.onItemClick(itemView) }
        }

        fun bind(string: String) {
            itemView.tvExplode.text = string
        }
    }

    public interface Callback {
        fun onItemClick(itemView: View)
    }

}