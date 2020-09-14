package com.nicoqueijo.fetchrewards.expandable

import com.nicoqueijo.fetchrewards.model.Item
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class ListId(title: String, items: List<Item?>) : ExpandableGroup<Item>(title, items)