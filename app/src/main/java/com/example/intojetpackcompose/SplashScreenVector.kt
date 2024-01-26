package com.example.intojetpackcompose

import android.opengl.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.EaseOutExpo
import androidx.compose.animation.core.EaseOutQuart
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioHighBouncy
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser

object DishyPaths {
    val plate = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M54.257,49.395c-0.471,0.269 -1.004,0.41 -1.546,0.41c-1.253,0 -3.653,0 -5.217,0c-0.945,0 -1.838,0.429 -2.429,1.165c-0.235,0.293 -0.488,0.608 -0.723,0.901c-0.591,0.737 -1.484,1.165 -2.428,1.165c-4.134,0 -15.694,0 -19.828,0c-0.944,0 -1.837,-0.428 -2.428,-1.165c-0.235,-0.293 -0.488,-0.608 -0.723,-0.901c-0.591,-0.736 -1.484,-1.165 -2.429,-1.165c-1.564,0 -3.964,0 -5.217,0c-0.542,0 -1.075,-0.141 -1.546,-0.41c-1.683,-0.962 -5.743,-3.283 -5.743,-3.283l56,0c0,0 -4.06,2.321 -5.743,3.283Z"
    ).toNodes()

    val dishCover = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M57,46.051c0,0.081 -50,0.081 -50,0c0,-13.798 11.202,-25 25,-25c13.798,0 25,11.202 25,25Z"
    ).toNodes()

    val lightEffectLine1 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M13,46.066c0,-3.34 0.864,-6.48 2.38,-9.209"
    ).toNodes()


    val lightEffectLine2 =
        androidx.compose.ui.graphics.vector.PathParser().parsePathString(
            "M20.294,31.104c1.214,-0.952 2.546,-1.758 3.97,-2.395"
        ).toNodes()


    val handle = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M32,20.869l0,-4"
    ).toNodes()

    val topHandle = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M37,16.869l-10,0"
    ).toNodes()

    val steamLine1 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M10.704,18.869c0,0 1.226,-2.87 -0.334,-6.214"
    ).toNodes()

    val steamLine2 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M53.296,18.869c0,0 -1.226,-2.87 0.334,-6.214"
    ).toNodes()

    val steamLine3 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M20.285,12.655c0,0 1.227,-2.871 -0.334,-6.215"
    ).toNodes()

    val steamLine4 = androidx.compose.ui.graphics.vector.PathParser().parsePathString(
        "M43.715,12.655c0,0 -1.227,-2.871 0.334,-6.215"
    ).toNodes()
}

@Preview
@Composable
fun dishyAnimation() : VectorPainter{
    val vectorPainter = rememberVectorPainter(
        defaultWidth =64.dp,
        defaultHeight = 64.dp,
        viewportWidth = 64f,
        viewportHeight = 64f,
        autoMirror = true
    ) {viewPortWidth,viewPortHeight ->

        val duration = 12000
        val transition = rememberInfiniteTransition()

        val transitionY by transition.animateFloat(
            initialValue = -30f,
            targetValue = 5f,
            animationSpec = infiniteRepeatable(
                tween(duration, easing = EaseOutExpo),
                repeatMode = RepeatMode.Reverse
            )
        )


        val transitionY2 by transition.animateFloat(
            initialValue = -6f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                tween(2000, easing = EaseOutQuart),
                repeatMode = RepeatMode.Reverse
            )
        )

        val transitionX by transition.animateFloat(
            initialValue = 1.2f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                tween(1000, easing = EaseInOutBounce)
            )
        )

        Group(name = "Dishy", translationY = transitionY) {

            Group(name = "plate",
                translationY = transitionY2) {

                Path(pathData = DishyPaths.plate,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)

                Path(pathData = DishyPaths.dishCover,
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f)

                Path(pathData = DishyPaths.lightEffectLine1,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)

                Path(pathData = DishyPaths.lightEffectLine2,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.2f)


            }
            Group(name = "dishCover"){

                Path(pathData = DishyPaths.topHandle,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)




            }

            Group(name="steam", translationX = transitionX){
                Path(pathData = DishyPaths.steamLine1,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)

                Path(pathData = DishyPaths.steamLine2,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)

                Path(pathData = DishyPaths.steamLine3,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)

                Path(pathData = DishyPaths.steamLine4,
                    fill = SolidColor(Color.White),
                    fillAlpha = 0.4f)
            }


            }


        }
      return vectorPainter
    }



