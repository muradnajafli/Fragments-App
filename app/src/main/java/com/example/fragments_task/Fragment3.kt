package com.example.fragments_task

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments_task.databinding.Fragment3Binding


class Fragment3 : Fragment() {
    private lateinit var view: View
    private lateinit var binding: Fragment3Binding
    private var backGroundColor: Int = Color.WHITE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment3Binding.inflate(layoutInflater)
        view = binding.root

        return view
    }
    fun changeBackgroundColor(color: Int) {
        backGroundColor = color
        view.setBackgroundColor(color)
    }

    fun getBackgroundColor(): Int {
        return backGroundColor
    }
}