package com.example.juicetracker.ui.bottomsheet

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.juicetracker.data.JuiceColor


class SpinnerAdapter(val onColorChange: (Int) -> Unit) : AdapterView.OnItemSelectedListener{
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        onColorChange(position)   // khi chọn màu, trả về chỉ số
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        onColorChange(0)          // mặc định là màu đầu tiên (đỏ)
    }

}
@Composable
fun ColorSpinnerRow(
    colorSpinnerPosition: Int,      // vị trí màu hiện tại
    onColorChange: (Int) -> Unit,   // callback khi đổi màu
    modifier: Modifier = Modifier
) {
    // Chuyển enum JuiceColor sang chuỗi hiển thị
    val juiceColorArray = JuiceColor.values().map { juiceColor ->
        stringResource(juiceColor.label)
    }

    // Tạo InputRow chứa Spinner
    InputRow(inputLabel = "Color", modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                Spinner(context).apply {
                    adapter = ArrayAdapter(
                        context,
                        R.layout.simple_spinner_dropdown_item,
                        juiceColorArray
                    )
                }
            },
            update = { spinner ->
                spinner.setSelection(colorSpinnerPosition)       // đặt màu hiện tại
                spinner.onItemSelectedListener = SpinnerAdapter(onColorChange) // xử lý chọn màu
            }
        )
    }
}
private fun findColorIndex(color: String): Int {
    val juiceColor = JuiceColor.valueOf(color)
    return JuiceColor.values().indexOf(juiceColor)
}