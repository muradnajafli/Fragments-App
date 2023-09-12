package com.example.fragments_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.fragments_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment2: Fragment2
    private lateinit var fragment3: Fragment3
    private var isSwapped = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragment2 = Fragment2()
        fragment3 = Fragment3()

        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment2, fragment2)
            .replace(R.id.Fragment3, fragment3)
            .commit()

    }

    fun changeFragmentColors(color1: Int, color2: Int) {
        fragment2.changeBackgroundColor(color1)
        fragment3.changeBackgroundColor(color2)
    }

    fun swapFragmentsPosition() {
        val fragment2Container = fragment2.view
        val fragment3Container = fragment3.view

        val parent2 = fragment2Container?.parent as? ViewGroup
        val parent3 = fragment3Container?.parent as? ViewGroup

        parent2?.removeView(fragment2Container)
        parent3?.removeView(fragment3Container)

        parent2?.addView(fragment3Container)
        parent3?.addView(fragment2Container)

        isSwapped = !isSwapped
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color1", fragment2.getBackgroundColor())
        outState.putInt("color2", fragment3.getBackgroundColor())
        outState.putBoolean("isSwapped", isSwapped)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val color1 = savedInstanceState.getInt("color1")
        val color2 = savedInstanceState.getInt("color2")
        changeFragmentColors(color1, color2)

        val fragmentSwapFlag = savedInstanceState.getBoolean("isSwapped")
        if (fragmentSwapFlag) {
            swapFragmentsPosition()
        }
    }
}
