package com.example.intojetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImage(url: String, vector: VectorPainter){

    val vectorState: MutableState<VectorPainter?> = mutableStateOf(null)


    Glide.with(LocalContext.current)


    }

