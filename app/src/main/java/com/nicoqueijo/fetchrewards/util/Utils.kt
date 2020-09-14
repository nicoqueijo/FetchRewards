package com.nicoqueijo.fetchrewards.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.nicoqueijo.fetchrewards.R
import com.nicoqueijo.fetchrewards.expandable.ListId
import com.nicoqueijo.fetchrewards.model.Item
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

object Utils {

    /**
     * Constants
     */
    const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    const val API_ENDPOINT = "hiring.json"

    /**
     * Extension functions
     */
    fun Context.isNetworkAvailable(): Boolean {
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

    fun Context.showNoInternetToast() =
        Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()

    fun List<Item?>.groupedItems(): Map<Int, List<Item?>> {
        return this.asSequence()
            .filter { !it?.name.isNullOrBlank() }
            .sortedBy { it?.id }
            .groupBy { it?.listId }
            .toSortedMap(compareBy { it })
    }

    fun Map<Int, List<Item?>>.toExpandableGroups(): List<ExpandableGroup<Item>> {
        val expandableGroups = mutableListOf<ExpandableGroup<Item>>()
        this.forEach { (listId, items) ->
            expandableGroups.add(ListId(listId.toString(), items))
        }
        return expandableGroups
    }
}