package com.nicoqueijo.fetchrewards.expandable

import android.view.View
import android.widget.TextView
import com.nicoqueijo.fetchrewards.R
import com.nicoqueijo.fetchrewards.model.Item
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class ItemViewHolder(itemView: View) : ChildViewHolder(itemView) {

    private var itemTitle: TextView = itemView.findViewById(R.id.item_title)

    fun setItemTitle(item: Item) {
        itemTitle.text = item.name
    }
}