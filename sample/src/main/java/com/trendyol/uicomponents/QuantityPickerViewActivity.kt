package com.trendyol.uicomponents

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trendyol.uicomponents.quantitypickerview.QuantityPickerViewState
import kotlinx.android.synthetic.main.activity_quantity_picker_view.*

class QuantityPickerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quantity_picker_view)

        val viewState = QuantityPickerViewState(
            text = "Fresh Money",
            textSize = asSP(12),
            quantityTextSize = asSP(14),
            backgroundDrawable = drawable(R.drawable.qpv_shape_default_background),
            removeIconDrawable = drawable(R.drawable.qpv_ic_default_remove),
            subtractIconDrawable = drawable(R.drawable.qpv_ic_default_subtract),
            addIconDrawable = drawable(R.drawable.qpv_ic_default_add),
            quantityBackgroundDrawable = drawable(R.drawable.qpv_shape_default_background),
            textColor = themeColor(R.attr.colorAccent),
            progressTintColor = themeColor(R.attr.colorAccent),
            quantityTextColor = themeColor(R.attr.colorPrimary)
        )

        quantity_picker_view_2.setQuantityPickerViewState(viewState)

        with(quantity_picker_view) {
            onAddClicked = { number ->
                Toast.makeText(context, "Add click: $number", Toast.LENGTH_SHORT).show()
                completeLoading()
                true
            }
            onSubtractClicked = { number ->
                Toast.makeText(context, "Subtract/Remove click: $number", Toast.LENGTH_SHORT).show()
                false
            }
        }
        button_reset.setOnClickListener {
            quantity_picker_view.reset()
            quantity_picker_view_2.reset()
        }
    }

    private fun completeLoading(delay: Long = 500L) {
        quantity_picker_view.postDelayed({
            quantity_picker_view.stopLoading()
        }, delay)
    }
}