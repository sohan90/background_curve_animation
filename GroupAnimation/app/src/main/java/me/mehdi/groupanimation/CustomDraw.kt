package me.mehdi.groupanimation

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class CustomDraw(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var eventX: Float = 0f
    private var eventY: Float  = 0f

    private var rect:RectF = RectF()
    private var paint: Paint = Paint()
    private var path: Path = Path()

    init {
        paint.color = Color.RED
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        path.moveTo(700f, 400f)
        path.lineTo(1000f, 1400f)
        path.lineTo(200f, 1400f)
        path.lineTo(700f, 400f)
        //path.close()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas?.drawPath(path, paint)

        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = 15f
        canvas?.drawPath(path, paint)
        //canvas?.drawRoundRect(eventX,eventY, eventX + 10f, eventY+10f, 0f,0f, paint)
        canvas?.drawRoundRect(rect, 10f,10f, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
         eventX = event?.x!!
         eventY = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                rect.left = eventX
                rect.top = eventY
                path.moveTo(eventX, eventY)
            }
            MotionEvent.ACTION_MOVE -> {
                rect.right =  rect.left+ abs(rect.left - eventX)
                rect.bottom =  rect.top+ abs(rect.top - eventY)
                path.lineTo(eventX, eventY)
                invalidate()
            }

            MotionEvent.ACTION_UP ->{}
        }
        return true;
    }
}