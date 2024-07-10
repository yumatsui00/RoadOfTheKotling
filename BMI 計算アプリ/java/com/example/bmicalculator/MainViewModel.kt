package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

//view model class: 画面の移動（回転や最小化）の際にデータを保持することができるクラス
class MainViewModel : ViewModel() {
    //今回rememberはいらない→main view model にメモリを分離しているから
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf(0f)

    //bmi = kg / (m*m)
    fun calculatebmi() {
        var h = height.toFloatOrNull()?.div(100) ?: 0f //100で割るか、０を返す
        var w = weight.toFloatOrNull() ?:0f

        bmi = if (h > 0f && w > 0f) {
            (w / h.pow(2) * 10).roundToInt() / 10f //小数点第一位までほしいから、１０かけてイントにして、１０で割る
        } else 0f
    }
}
