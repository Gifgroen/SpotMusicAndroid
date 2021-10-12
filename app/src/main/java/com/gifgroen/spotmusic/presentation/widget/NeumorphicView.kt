package com.gifgroen.spotmusic.presentation.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat.getColor
import com.gifgroen.spotmusic.R


class NeumorphicView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val path = Path().apply {
        setBackgroundColor(getColor(context, R.color.green))
    }

    private val cornerRadius = 32f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val rectF = RectF(0f, 0f, w.toFloat(), h.toFloat())
        resetPath(path, rectF, cornerRadius)
    }

    override fun draw(canvas: Canvas) {
        val save: Int = canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restoreToCount(save)
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save: Int = canvas.save()
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    private fun resetPath(path: Path, rect: RectF, radius: Float) {
        path.reset()
        path.addRoundRect(rect, radius, radius, Path.Direction.CW)
        path.close()
    }

}