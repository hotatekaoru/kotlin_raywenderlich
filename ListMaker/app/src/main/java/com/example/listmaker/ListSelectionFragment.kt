package com.example.listmaker

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListSelectionFragment : Fragment(), ListSelectionRecyclerViewAdapter.ListSelectionRecyclerViewClickListener {
    override fun listItemClicked(list: TaskList) {
        listener?.onListItemClicked(list)
    }

    private var listener: OnFragmentInteractionListener? = null
    lateinit var listsRecyclerView: RecyclerView
    lateinit var listDataManeger: ListDataManeger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_selection_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
            listDataManeger = ListDataManeger(context)
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onListItemClicked(list: TaskList)
    }

    fun addList(list: TaskList) {
        listDataManeger.saveList(list)
        val recyclerAdapter = listsRecyclerView.adapter as ListSelectionRecyclerViewAdapter
        recyclerAdapter.addList(list)
    }

    fun saveList(list: TaskList) {
        listDataManeger.saveList(list)
        updateLists()
    }

    private fun updateLists() {
        val lists = listDataManeger.readLists()
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter(lists, this)
    }

    companion object {
        fun newInstance(param1: String, param2: String): ListSelectionFragment {
            return ListSelectionFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.let {
            val lists = listDataManeger.readLists()
            listsRecyclerView = it.findViewById<RecyclerView>(R.id.lists_recyclerview)
            listsRecyclerView.layoutManager = LinearLayoutManager(activity)
            listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter(lists, this)
        }
    }
}
