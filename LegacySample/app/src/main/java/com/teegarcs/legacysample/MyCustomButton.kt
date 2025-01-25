package com.teegarcs.legacysample

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class MyCustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    fun setCustomClick(callback: () -> Unit) {
        setOnClickListener { callback.invoke() }
    }

    fun setLabel(label: String) {
        setText(label)
    }
}