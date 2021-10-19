package me.mehdi.groupanimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.lang.Math.abs


class CurveBackgroudView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var rect: RectF
    private var rect2: RectF
    private var paint: Paint? = null
    private var paint2: Paint? = null
    var straithLine = 300f

    init {
        paint = Paint()
        paint2 = Paint()
        rect = RectF()
        rect2 = RectF()
    }

    fun changeLine() {
        val valueanim = ValueAnimator.ofFloat(300f, 0f)
        valueanim.addUpdateListener {
            val valu: Float = it.animatedValue as Float
            straithLine = kotlin.math.abs(valu)
            rect.setEmpty()
            rect2.setEmpty()
            invalidate()
        }
        valueanim.duration = 1000
        valueanim.start()
    }


    override fun onDraw(canvas: Canvas) {
        rect.left = -50f
        rect.top = height / 2.5f
        rect.right = width + 50f
        rect.bottom = rect.top + straithLine

        paint?.color = Color.RED
        paint?.style = Paint.Style.FILL
        paint?.isAntiAlias = true
        canvas.drawArc(rect, 0f,180f, false , paint!!)

        rect2.left = 0f
        rect2.top = 0f
        rect2.right = rect2.left + width
        rect2.bottom = rect.top + straithLine / 2

        //arc rect
        paint2!!.color = Color.TRANSPARENT
        canvas.drawRect(rect, paint2!!)

        //top space rect
        paint2!!.color = Color.RED
        canvas.drawRect(rect2, paint2!!)

    }
}