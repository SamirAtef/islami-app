package com.example.islami_final.ui.hadithDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_final.R

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadithContenteAdapter

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadith_details)
        setSupportActionBar(findViewById(R.id.hadith_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView = findViewById(R.id.title_text_hadith)
        initRecycler()
        val hadithName: String? = intent.getStringExtra("hadithName")
        val hadithPos: Int = intent.getIntExtra("hadithpos", -1)
        titleTextView.setText(hadithName)
        readHadithFile(hadithPos)
    }

    private fun readHadithFile(pos: Int) {
        val fileName = "h${pos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }

    private fun initRecycler() {
        recyclerView = findViewById(R.id.hadith_content_recycler)
        adapter = HadithContenteAdapter()
        recyclerView.adapter = adapter
    }


}