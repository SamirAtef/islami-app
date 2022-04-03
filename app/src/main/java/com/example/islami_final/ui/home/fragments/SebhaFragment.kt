package com.example.islami_final.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.islami_final.R


class SebhaFragment : Fragment() {
    lateinit var tasbihNumber: Button
    lateinit var zikrNumber: Button
    var Number: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        zikrNumber.setOnClickListener(
            View.OnClickListener {
                Number++
                tasbihNumber.text = Number.toString()
                zikrName(Number)
            })


    }

    private fun initViews() {
        tasbihNumber = requireView().findViewById(R.id.tasbih_number_button)
        zikrNumber = requireView().findViewById(R.id.zikr_button)
    }

    fun zikrName(number: Int = Number) {
        if (number in 0..33) {
            zikrNumber.setText("الله اكبر")
        } else if (number in 33..66) {
            zikrNumber.setText("سبحان الله")
        } else if (number in 66..99) {
            zikrNumber.setText(" الحمد لله ")
        } else {
            Number = 0
        }

    }

}





