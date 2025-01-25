package com.teegarcs.legacysample

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            viewModel.viewState.collect {
                findViewById<TextView>(R.id.count_value).setText(it.count.toString())
            }
        }

        findViewById<MyCustomButton>(R.id.increment).run {
            setCustomClick { viewModel.processIntent(MainIntent.Increment) }
            setLabel(getString(R.string.increment))
        }

        findViewById<MyCustomButton>(R.id.decrement).run {
            setCustomClick { viewModel.processIntent(MainIntent.Decrement) }
            setLabel(getString(R.string.decrement))
        }

    }
}