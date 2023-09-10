package com.example.fragments_task

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments_task.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var view: View
    private lateinit var binding: Fragment2Binding
    private var backgroundColor: Int = Color.WHITE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(inflater)
        view = binding.root


        return view
    }
    fun changeBackgroundColor(color: Int) {
        backgroundColor = color

        view.setBackgroundColor(color)
    }
    fun getBackgroundColor(): Int {
        return backgroundColor
    }

}