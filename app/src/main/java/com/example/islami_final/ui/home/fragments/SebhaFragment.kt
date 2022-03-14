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
    var number: Int = 0
    val tasbehNameList = listOf<String>("سبحان الله \n", "الحمد لله \n", "الله اكبر")
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
                number++
                tasbihNumber.text = number.toString()
            })
        if (number == 0) {
            zikrNumber.setText("الله اكبر")
        } else if (number == 33) {
            zikrNumber.setText("سبحان الله")
        } else if (number == 66) {
            zikrNumber.setText(" الحمد لله ")
        } else {
            number = 0
            zikrNumber.setText("الله اكبر ")
        }
    }

    private fun initViews() {
        tasbihNumber = requireView().findViewById(R.id.tasbih_number_button)
        zikrNumber = requireView().findViewById(R.id.zikr_button)
    }

}





