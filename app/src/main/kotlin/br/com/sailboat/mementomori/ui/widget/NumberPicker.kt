package br.com.sailboat.mementomori.ui.widget

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker
import br.com.sailboat.mementomori.R

class NumberPicker(context: Context?, attrs: AttributeSet?) : NumberPicker(context, attrs) {

    override fun addView(child: View?) {
        super.addView(child)
        updateView(child)
        Log.e("BRAYAN", "NumberPicker.addView 1")
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        updateView(child)
        Log.e("BRAYAN", "NumberPicker.addView 2")
    }

    override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
        super.addView(child, params)
        updateView(child)
        Log.e("BRAYAN", "NumberPicker.addView 3")
    }

    private fun updateView(child: View?) {
        if (child is EditText) {
            child.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.number_picker_text_size))
            child.typeface = Typeface.create("sans-serif-light", Typeface.NORMAL);
            child.setTextColor(ContextCompat.getColor(context, R.color.grey_70))
        }
    }

}