package com.example.islami_final.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_final.R
import com.example.islami_final.ui.hadithDetails.HadithDetailsActivity
import com.example.islami_final.ui.home.fragments.adapter.HadithNameAdapter

class HadithFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadith, container, false)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadithNameAdapter
    lateinit var itemList: MutableList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createHadithItems()
        initRecycler()
    }

    private fun initRecycler() {
        recyclerView = requireView().findViewById(R.id.hadith_recycler)
        adapter = HadithNameAdapter(itemList)
        adapter.onItemClickListener = object : HadithNameAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int, name: String) {
                showHadithDetails(pos, name)
            }
        }
        recyclerView.adapter = adapter
    }

    fun createHadithItems() {
        itemList = mutableListOf()
        for (i in 1..50) {
            itemList.add("الحديث رقم  $i")
        }
    }

    private fun showHadithDetails(pos: Int, name: String) {
        val intent = Intent(requireActivity(), HadithDetailsActivity::class.java)
        intent.putExtra("hadithName", name)
        intent.putExtra("hadithpos", pos)
        startActivity(intent);
    }
}