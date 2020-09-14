package com.nicoqueijo.fetchrewards.expandable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicoqueijo.fetchrewards.R
import com.nicoqueijo.fetchrewards.model.Item
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class ListIdAdapter(groups: List<ExpandableGroup<*>?>?) :
    ExpandableRecyclerViewAdapter<ListIdViewHolder, ItemViewHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): ListIdViewHolder {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.row_list_id, parent, false)
        return ListIdViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.row_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindChildViewHolder(
        holder: ItemViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {
        val item = (group as ListId).items[childIndex]
        holder?.setItemTitle(item)
    }

    override fun onBindGroupViewHolder(
        holder: ListIdViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        holder?.setListIdTitle(group as ExpandableGroup<Item>)
    }
}