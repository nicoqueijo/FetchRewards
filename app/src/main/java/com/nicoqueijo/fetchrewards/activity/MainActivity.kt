package com.nicoqueijo.fetchrewards.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.nicoqueijo.fetchrewards.R
import com.nicoqueijo.fetchrewards.expandable.ListIdAdapter
import com.nicoqueijo.fetchrewards.model.Item
import com.nicoqueijo.fetchrewards.repository.Repository
import com.nicoqueijo.fetchrewards.util.Utils
import com.nicoqueijo.fetchrewards.util.Utils.groupedItems
import com.nicoqueijo.fetchrewards.util.Utils.showNoInternetToast
import com.nicoqueijo.fetchrewards.util.Utils.toExpandableGroups
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListIdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository(this)
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getItems()
        viewModel.response.observe(this, { response ->
            if (response.isSuccessful) {
                initExpandableRecyclerView(response.body()!!)
            } else {
                showNoInternetToast()
            }
        })
    }

    private fun initExpandableRecyclerView(items: List<Item?>) {
        adapter = ListIdAdapter(items.groupedItems().toExpandableGroups())
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}