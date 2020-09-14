package com.nicoqueijo.fetchrewards.expandable

import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.nicoqueijo.fetchrewards.R
import com.nicoqueijo.fetchrewards.model.Item
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class ListIdViewHolder(listIdView: View) : GroupViewHolder(listIdView) {

    private var listIdTitle: TextView = listIdView.findViewById(R.id.list_id_title)
    private var arrow: ImageView = listIdView.findViewById(R.id.arrow)

    fun setListIdTitle(group: ExpandableGroup<Item>) {
        listIdTitle.text = group.title
    }

    override fun expand() {
        animateExpand()
    }

    override fun collapse() {
        animateCollapse()
    }

    private fun animateExpand() {
        val rotate = RotateAnimation(
            360F,
            180F,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 300
        rotate.fillAfter = true
        arrow.animation = rotate
    }

    private fun animateCollapse() {
        val rotate = RotateAnimation(
            180F,
            360F,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 300
        rotate.fillAfter = true
        arrow.animation = rotate
    }
}