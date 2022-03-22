package mx.edu.ladm_u2_ejercicio8_toques

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class imagen(l:Lienzo, recurso:Int, posX : Float, posY : Float) {
    val l = l
    val image = BitmapFactory.decodeResource(l.resources, recurso)
    var x = posX
    var y = posY

    fun mover(toqueX: Float, toqueY: Float){
        x = toqueX - (image.width/2)
        y = toqueY - (image.height/2)
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        canvas.drawBitmap(image, x, y, p)
    }

    fun estaEnArea(toqueX:Float, toqueY:Float):Boolean{
        var x2 = x+image.width
        var y2 = y+image.height

        if(toqueX>=x && toqueX<=x2){
            if(toqueY>=y && toqueY<=y2){
                return true
            }
        }
        return false
    }
}//class imagen