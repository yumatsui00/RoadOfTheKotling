package com.example.jettheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jettheme.ui.theme.JetThemeTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jettheme.components.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetThemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent();
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()) //これを追加するだけでスクロール可能になる
    ) {
        //prof pic
        Image(
            painter = painterResource(id = R.drawable.punpun),
            contentDescription = "pofile",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(100.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        //name
        Text(
            text = "yumatsui",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(20.dp))
        //job
        Text(
            text = "職業: 学生",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
        //company info
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth(),//中心寄せかつ幅を埋めることで左寄せになる
        ){
            CompanySection()
        }
        //detail button
        var isShowDetail by remember { mutableStateOf(false) } //状態が更新されたら、描画し直す。rememberはstatic みたいなもの
        Button(
            modifier = Modifier.fillMaxWidth(),
            // ボタンの色は変え方が少し特殊
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A)),
            //ClickするとonClickの中身が実行される
            onClick = { isShowDetail = !isShowDetail },
        ) {
            Text(text = "詳細を表示", color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (isShowDetail) {
            DetailSection()
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetThemeTheme {
//        Greeting("Android")
//    }
//}