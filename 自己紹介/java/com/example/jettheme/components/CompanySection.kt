package com.example.jettheme.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanySection(){
    //company info
    Text(
        text = "42Tokyo",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(10.dp))

    //group name
    Text(
        text = "Forest Green",
        color = Color.Gray,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(20.dp))

    //Email
    Label(icon = Icons.Default.Email, text = "Email")

    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "Helloworld123@gmail.com", fontSize = 16.sp)
    Spacer(modifier = Modifier.height(5.dp))
    Divider(
        modifier = Modifier.clip(RoundedCornerShape(1000.dp)),
        thickness = 2.dp
    )
    Spacer(modifier = Modifier.height(20.dp))
}