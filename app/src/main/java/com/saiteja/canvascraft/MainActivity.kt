package com.saiteja.canvascraft

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saiteja.canvascraft.ui.theme.CanvasCraftTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanvasCraftTheme {
                var isDarkMode by remember { mutableStateOf(true) }
                val bgColor = if(isDarkMode) Color(0xFF2A2A2A) else Color(0xFFF5F0EB)
                val boxColor = if(isDarkMode) Color(0xFFF0E8DC) else Color(0xFF2A2A2A)
                val previewBoxColor = if(isDarkMode) Color(0xFFF5F0EB) else Color(0xFFAAAAAA)
                val textColor = if(isDarkMode) Color.Black else Color.White
                val screenTextColor = if(isDarkMode) Color.White else Color.Black
                val gridBg = if(isDarkMode) Color(0xFFF5F0EB) else Color(0xFF2A2A2A)
                var cell1image by remember { mutableStateOf<Int?>(null) }
                var cell2image by remember { mutableStateOf<Int?>(null) }
                var cell3image by remember { mutableStateOf<Int?>(null) }
                var cell4image by remember { mutableStateOf<Int?>(null) }
                var cell5image by remember { mutableStateOf<Int?>(null) }
                var offsetX by remember { mutableFloatStateOf(0f) }
                var offsetY by remember { mutableFloatStateOf(0f) }
                var offsetX1 by remember { mutableFloatStateOf(0f) }
                var offsetY1 by remember { mutableFloatStateOf(0f) }
                var offsetX2 by remember { mutableFloatStateOf(0f) }
                var offsetY2 by remember { mutableFloatStateOf(0f) }
                var offsetX3 by remember { mutableFloatStateOf(0f) }
                var offsetY3 by remember { mutableFloatStateOf(0f) }
                var offsetX4 by remember { mutableFloatStateOf(0f) }
                var offsetY4 by remember { mutableFloatStateOf(0f) }
                var scale by remember { mutableStateOf(1f) }
                var scale1 by remember { mutableStateOf(1f) }
                var scale2 by remember { mutableStateOf(1f) }
                var scale3 by remember { mutableStateOf(1f) }
                var scale4 by remember { mutableStateOf(1f) }
                var rotation by remember { mutableStateOf(0f) }
                var rotation1 by remember { mutableStateOf(0f) }
                var rotation2 by remember { mutableStateOf(0f) }
                var rotation3 by remember { mutableStateOf(0f) }
                var rotation4 by remember { mutableStateOf(0f) }
                var selectedCell by remember { mutableStateOf(0) }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(bgColor)
                    ) {
                        var currentScreen by remember { mutableStateOf("gallery") }
                        var selector by remember { mutableStateOf("") }
                        if (currentScreen == "gallery") {
                            Column(
                                modifier = Modifier.fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Spacer(modifier = Modifier.height(40.dp))
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(0.dp)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(boxColor)
                                    ) {
                                        Text(
                                            text = "GALLERY",
                                            fontSize = 40.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace,
                                            color = textColor,
                                            letterSpacing = 2.sp
                                        )
                                    }
                                }
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        text = "CHOOSE LAYOUT",
                                        color = screenTextColor,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace,
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .background(
                                                boxColor,
                                                RoundedCornerShape(16.dp)
                                            )
                                            .padding(vertical = 12.dp)
                                            .clickable {
                                                selector = "You selected a 2-GRID layout."
                                                currentScreen = "editor"
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "2 GRID",
                                            color = textColor,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .background(
                                                boxColor,
                                                RoundedCornerShape(16.dp)
                                            )
                                            .padding(vertical = 12.dp)
                                            .clickable {
                                                selector = "You selected a 3-GRID layout."
                                                currentScreen = "editor"
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "3 GRID",
                                            color = textColor,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace,
                                        )
                                    }
                                }
                                Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                                    Row(modifier = Modifier.weight(1f)) {
                                        Box(
                                            modifier = Modifier
                                                .height(200.dp)
                                                .weight(1f)
                                                .background(previewBoxColor)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Box(
                                            modifier = Modifier
                                                .height(200.dp)
                                                .weight(1f)
                                                .background(previewBoxColor)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(22.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row() {
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Box(
                                            modifier = Modifier
                                                .height(95.dp)
                                                .fillMaxWidth()
                                                .background(previewBoxColor)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .background(
                                                boxColor,
                                                RoundedCornerShape(16.dp)
                                            )
                                            .padding(vertical = 12.dp)
                                            .clickable {
                                                selector = "You selected a 4-GRID layout."
                                                currentScreen = "editor"
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "4 GRID",
                                            color = textColor,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .background(
                                                boxColor,
                                                RoundedCornerShape(16.dp)
                                            )
                                            .padding(vertical = 12.dp)
                                            .clickable {
                                                selector = "You selected a 5-GRID layout."
                                                currentScreen = "editor"
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "5 GRID",
                                            color = textColor,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }
                                Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row() {
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Row() {
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Box(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(32.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row {
                                            Box(
                                                modifier = Modifier
                                                    .height(61.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Box(
                                                modifier = Modifier
                                                    .height(61.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Row {
                                            Box(
                                                modifier = Modifier
                                                    .height(61.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Box(
                                                modifier = Modifier
                                                    .height(61.dp)
                                                    .weight(1f)
                                                    .background(previewBoxColor)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Box(
                                            modifier = Modifier
                                                .height(70.dp)
                                                .fillMaxWidth()
                                                .background(previewBoxColor)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                if(isDarkMode == true){
                                    Box(modifier = Modifier
                                            .padding(4.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(boxColor)
                                            .clickable {
                                               isDarkMode = false
                                            },
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Text(
                                            "Light Mode",
                                            color = textColor,
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }
                                else{
                                    Box(modifier = Modifier
                                        .padding(4.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(boxColor)
                                        .clickable {
                                            isDarkMode = true
                                        },
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Text(
                                            "Dark Mode",
                                            color = textColor,
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }
                            }
                        }
                        if (currentScreen == "editor") {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(25.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                var radiusValue by remember { mutableFloatStateOf(0f) }
                                var spacingValue by remember { mutableFloatStateOf(0f) }
                                Spacer(modifier = Modifier.height(4.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(0.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(boxColor)
                                ) {
                                    Text(
                                        "  CUSTOM EDITOR",
                                        color = textColor,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                if (selector == "You selected a 2-GRID layout.") {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(450.dp)
                                            .clip(RoundedCornerShape(radiusValue.dp))
                                            .background(gridBg)
                                            .padding(4.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .padding(1.dp)
                                                    .clip(RoundedCornerShape(radiusValue.dp))
                                                    .background(Color.Gray)
                                                    .clickable {
                                                        selectedCell = 1
                                                        currentScreen = "imagePicker"
                                                    }
                                                    .pointerInput(Unit) {
                                                        detectTransformGestures { centroid, pan, zoom, rot ->
                                                            scale *= zoom
                                                            offsetX += pan.x
                                                            offsetY += pan.y
                                                            rotation += rot
                                                        }
                                                    }
                                            ) {
                                                if (cell1image != null) {  // only show image if selected!
                                                    Image(
                                                        painter = painterResource(id = cell1image!!),
                                                        contentDescription = null,
                                                        modifier = Modifier.fillMaxSize()
                                                            .graphicsLayer {
                                                                scaleX = scale
                                                                scaleY = scale
                                                                translationX = offsetX
                                                                translationY = offsetY
                                                                rotationZ = rotation
                                                            }
                                                    )
                                                }
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .padding(1.dp)
                                                    .clip(RoundedCornerShape(radiusValue.dp))
                                                    .background(Color.Gray)
                                                    .clickable {
                                                        selectedCell = 2
                                                        currentScreen = "imagePicker"
                                                    }
                                                    .pointerInput(Unit) {
                                                        detectTransformGestures { centroid, pan, zoom, rot ->
                                                            scale1 *= zoom
                                                            offsetX1 += pan.x
                                                            offsetY1 += pan.y
                                                            rotation1 += rot
                                                        }
                                                    }
                                            ) {
                                                if (cell2image != null) {  // only show image if selected!
                                                    Image(
                                                        painter = painterResource(id = cell2image!!),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .graphicsLayer {
                                                                scaleX = scale1
                                                                scaleY = scale1
                                                                translationX = offsetX1
                                                                translationY = offsetY1
                                                                rotationZ = rotation1
                                                            }
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                if (selector == "You selected a 3-GRID layout.") {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(450.dp)
                                            .clip(RoundedCornerShape(radiusValue.dp ))
                                            .padding(4.dp)
                                            .background(gridBg)
                                    )
                                    {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.spacedBy( spacingValue.dp )
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy( spacingValue.dp )
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .height(225.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            selectedCell = 1
                                                            currentScreen = "imagePicker"
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale *= zoom
                                                                offsetX += pan.x
                                                                offsetY += pan.y
                                                                rotation += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell1image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell1image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale
                                                                    scaleY = scale
                                                                    translationX = offsetX
                                                                    translationY = offsetY
                                                                    rotationZ = rotation
                                                                }
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .height(225.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            selectedCell = 2
                                                            currentScreen = "imagePicker"
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale1 *= zoom
                                                                offsetX1 += pan.x
                                                                offsetY1 += pan.y
                                                                rotation1 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell2image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell2image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale1
                                                                    scaleY = scale1
                                                                    translationX = offsetX1
                                                                    translationY = offsetY1
                                                                    rotationZ = rotation1
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .weight(1f)
                                                    .clip(RoundedCornerShape(radiusValue.dp))
                                                    .padding(1.dp)
                                                    .background(Color.Gray)
                                                    .clickable {
                                                        selectedCell = 3
                                                        currentScreen = "imagePicker"
                                                    }
                                                    .pointerInput(Unit) {
                                                        detectTransformGestures { centroid, pan, zoom, rot ->
                                                            scale2 *= zoom
                                                            offsetX2 += pan.x
                                                            offsetY2 += pan.y
                                                            rotation2 += rot
                                                        }
                                                    }
                                            ) {
                                                if (cell3image != null) {  // only show image if selected!
                                                    Image(
                                                        painter = painterResource(id = cell3image!!),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .graphicsLayer {
                                                                scaleX = scale2
                                                                scaleY = scale2
                                                                translationX = offsetX2
                                                                translationY = offsetY2
                                                                rotationZ = rotation2
                                                            }
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                if (selector == "You selected a 4-GRID layout.") {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(450.dp)
                                            .clip(RoundedCornerShape(radiusValue.dp))
                                            .background(gridBg)
                                            .padding(4.dp)
                                    ) {
                                        Column(modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.spacedBy( spacingValue.dp)
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .weight(1f)
                                                    .background(gridBg)
                                                    .clip(RoundedCornerShape(radiusValue.dp)),
                                                horizontalArrangement = Arrangement.spacedBy( spacingValue.dp)
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .fillMaxSize()
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 1
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale *= zoom
                                                                offsetX += pan.x
                                                                offsetY += pan.y
                                                                rotation += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell1image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell1image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale
                                                                    scaleY = scale
                                                                    translationX = offsetX
                                                                    translationY = offsetY
                                                                    rotationZ = rotation
                                                                }
                                                        )
                                                    }

                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .fillMaxSize()
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 2
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale1 *= zoom
                                                                offsetX1 += pan.x
                                                                offsetY1 += pan.y
                                                                rotation1 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell2image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell2image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale1
                                                                    scaleY = scale1
                                                                    translationX = offsetX1
                                                                    translationY = offsetY1
                                                                    rotationZ = rotation1
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .weight(1f)
                                                    .background(gridBg)
                                                    .clip(RoundedCornerShape(radiusValue.dp)),
                                                horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                                            )
                                            {
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .fillMaxHeight()
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 3
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale2 *= zoom
                                                                offsetX2 += pan.x
                                                                offsetY2 += pan.y
                                                                rotation2 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell3image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell3image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale2
                                                                    scaleY = scale2
                                                                    translationX = offsetX2
                                                                    translationY = offsetY2
                                                                    rotationZ = rotation2
                                                                }
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .fillMaxHeight()
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .fillMaxWidth()
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 4
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale3 *= zoom
                                                                offsetX3 += pan.x
                                                                offsetY3 += pan.y
                                                                rotation3 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell4image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell4image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale3
                                                                    scaleY = scale3
                                                                    translationX = offsetX3
                                                                    translationY = offsetY3
                                                                    rotationZ = rotation3
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (selector == "You selected a 5-GRID layout.") {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(450.dp)
                                            .clip(RoundedCornerShape(radiusValue.dp))
                                            .padding(4.dp)
                                            .background(gridBg)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(RoundedCornerShape(radiusValue.dp)),
                                            verticalArrangement = Arrangement.spacedBy(spacingValue.dp)
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .clip(RoundedCornerShape(radiusValue.dp)),
                                                horizontalArrangement = Arrangement.spacedBy(
                                                    spacingValue.dp
                                                )
                                            )
                                            {
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 1
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale *= zoom
                                                                offsetX += pan.x
                                                                offsetY += pan.y
                                                                rotation += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell1image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell1image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale
                                                                    scaleY = scale
                                                                    translationX = offsetX
                                                                    translationY = offsetY
                                                                    rotationZ = rotation
                                                                }
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 2
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale1 *= zoom
                                                                offsetX1 += pan.x
                                                                offsetY1 += pan.y
                                                                rotation1 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell2image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell2image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale1
                                                                    scaleY = scale1
                                                                    translationX = offsetX1
                                                                    translationY = offsetY1
                                                                    rotationZ = rotation1
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .clip(RoundedCornerShape(radiusValue.dp)),
                                                horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .padding(1.dp)
                                                    .clip(RoundedCornerShape(radiusValue.dp))
                                                    .background(Color.Gray)
                                                    .clickable {
                                                        currentScreen = "imagePicker"
                                                        selectedCell = 3
                                                    }
                                                    .pointerInput(Unit) {
                                                        detectTransformGestures { centroid, pan, zoom, rot ->
                                                            scale2 *= zoom
                                                            offsetX2 += pan.x
                                                            offsetY2 += pan.y
                                                            rotation2 += rot
                                                        }
                                                    }
                                                ) {
                                                    if (cell3image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell3image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale2
                                                                    scaleY = scale2
                                                                    translationX = offsetX2
                                                                    translationY = offsetY2
                                                                    rotationZ = rotation2
                                                                }
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .weight(1f)
                                                        .padding(1.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 4
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale3 *= zoom
                                                                offsetX3 += pan.x
                                                                offsetY3 += pan.y
                                                                rotation3 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell4image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell4image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale3
                                                                    scaleY = scale3
                                                                    translationX = offsetX3
                                                                    translationY = offsetY3
                                                                    rotationZ = rotation3
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .weight(1f)
                                            )   {
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                        .padding(1.dp)
                                                        .clip(RoundedCornerShape(radiusValue.dp))
                                                        .background(Color.Gray)
                                                        .clickable {
                                                            currentScreen = "imagePicker"
                                                            selectedCell = 5
                                                        }
                                                        .pointerInput(Unit) {
                                                            detectTransformGestures { centroid, pan, zoom, rot ->
                                                                scale4 *= zoom
                                                                offsetX4 += pan.x
                                                                offsetY4 += pan.y
                                                                rotation4 += rot
                                                            }
                                                        }
                                                ) {
                                                    if (cell5image != null) {  // only show image if selected!
                                                        Image(
                                                            painter = painterResource(id = cell5image!!),
                                                            contentDescription = null,
                                                            modifier = Modifier.fillMaxSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale4
                                                                    scaleY = scale4
                                                                    translationX = offsetX4
                                                                    translationY = offsetY4
                                                                    rotationZ = rotation4
                                                                }
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(32.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(boxColor)
                                ) {
                                    Text(
                                        "RADIUS : ${radiusValue.toInt()}",
                                        color = textColor,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Slider(
                                    value = radiusValue,
                                    onValueChange = { newValue -> radiusValue = newValue },
                                    valueRange = 0f..100f,
                                    colors = SliderDefaults.colors(
                                        thumbColor = boxColor,
                                        activeTrackColor = boxColor
                                    ),
                                )
                                Spacer(modifier = Modifier.height(22.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(boxColor)
                                ) {
                                    Text(
                                        "SPACING : ${spacingValue.toInt()}",
                                        color = textColor,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Slider(
                                    value = spacingValue,
                                    onValueChange = { newValue -> spacingValue = newValue },
                                    valueRange = 0f..100f,
                                    colors = SliderDefaults.colors(
                                        thumbColor = boxColor,
                                        activeTrackColor = boxColor
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier
                                        .padding(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(4.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(boxColor)
                                            .clickable{},
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Text(
                                            "EXPORT",
                                            color = textColor,
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(boxColor)
                                        .clickable {
                                            currentScreen = "gallery"
                                            cell1image = null
                                            cell2image = null
                                            cell3image = null
                                            cell4image = null
                                            cell5image = null
                                        },
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Text(
                                        "Go Back",
                                        color = textColor,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                            }
                        }
                        if (currentScreen == "imagePicker") {
                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.avengers
                                                if (selectedCell == 2) cell2image = R.drawable.avengers
                                                if (selectedCell == 3) cell3image = R.drawable.avengers
                                                if (selectedCell == 4) cell4image = R.drawable.avengers
                                                if (selectedCell == 5) cell5image = R.drawable.avengers
                                            })
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.avengers),
                                            contentDescription = "avengers",
                                            /*contentScale = ContentScale.Crop,*/
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.ironman
                                                if (selectedCell == 2) cell2image = R.drawable.ironman
                                                if (selectedCell == 3) cell3image = R.drawable.ironman
                                                if (selectedCell == 4) cell4image = R.drawable.ironman
                                                if (selectedCell == 5) cell5image = R.drawable.ironman
                                            }
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.ironman),
                                            contentDescription = "ironman",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.thorr
                                                if (selectedCell == 2) cell2image = R.drawable.thorr
                                                if (selectedCell == 3) cell3image = R.drawable.thorr
                                                if (selectedCell == 4) cell4image = R.drawable.thorr
                                                if (selectedCell == 5) cell5image = R.drawable.thorr
                                            })
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.thorr),
                                            contentDescription = "thorr",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.tree
                                                if (selectedCell == 2) cell2image = R.drawable.tree
                                                if (selectedCell == 3) cell3image = R.drawable.tree
                                                if (selectedCell == 4) cell4image = R.drawable.tree
                                                if (selectedCell == 5) cell5image = R.drawable.tree
                                            })
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.tree),
                                            contentDescription = "tree",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.avengers2
                                                if (selectedCell == 2) cell2image = R.drawable.avengers2
                                                if (selectedCell == 3) cell3image = R.drawable.avengers2
                                                if (selectedCell == 4) cell4image = R.drawable.avengers2
                                                if (selectedCell == 5) cell5image = R.drawable.avengers2
                                            }
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.avengers2),
                                            contentDescription = "avengers2",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.blackpanther
                                                if (selectedCell == 2) cell2image = R.drawable.blackpanther
                                                if (selectedCell == 3) cell3image = R.drawable.blackpanther
                                                if (selectedCell == 4) cell4image = R.drawable.blackpanther
                                                if (selectedCell == 5) cell5image = R.drawable.blackpanther
                                            })
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.blackpanther),
                                            contentDescription = "blackpanther",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.moon
                                                if (selectedCell == 2) cell2image = R.drawable.moon
                                                if (selectedCell == 3) cell3image = R.drawable.moon
                                                if (selectedCell == 4) cell4image = R.drawable.moon
                                                if (selectedCell == 5) cell5image = R.drawable.moon
                                            })
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.moon),
                                            contentDescription = "moon",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(400.dp)
                                            .fillMaxWidth()
                                            .padding(6.dp)
                                            .background(Color.Gray)
                                            .clickable {
                                                currentScreen = "editor"
                                                if (selectedCell == 1) cell1image = R.drawable.mountain
                                                if (selectedCell == 2) cell2image = R.drawable.mountain
                                                if (selectedCell == 3) cell3image = R.drawable.mountain
                                                if (selectedCell == 4) cell4image = R.drawable.mountain
                                                if (selectedCell == 5) cell5image = R.drawable.mountain
                                            }
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.mountain),
                                            contentDescription = "mountain",
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(boxColor)
                                            .clickable {
                                                currentScreen = "editor"
                                            },
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Text(
                                            "Go Back",
                                            color = textColor,
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
}