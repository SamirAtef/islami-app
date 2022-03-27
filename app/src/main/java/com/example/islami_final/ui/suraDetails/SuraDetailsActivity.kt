package com.example.islami_final.ui.suraDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_final.Constants
import com.example.islami_final.R

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView = findViewById(R.id.title_text_view)
        initRecycler()
        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPos: Int = intent.getIntExtra(Constants.EXTRA_SURA_POS, -1)

        titleTextView.setText(suraName)

        readSuraFile(suraPos)

    }

    private fun initRecycler() {
        recyclerView = findViewById(R.id.sura_recycler)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }

    fun readSuraFile(pos: Int) {

        val fileName = "${pos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }

}
