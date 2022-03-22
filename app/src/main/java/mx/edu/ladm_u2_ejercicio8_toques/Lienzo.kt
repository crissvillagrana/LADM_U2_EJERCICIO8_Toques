package mx.edu.ladm_u2_ejercicio8_toques

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo (este: MainActivity) : View(este){//class lienzo
    val este = este
    var fondo = Color.BLACK
    var facebook = imagen(this,R.drawable.icono1, 200f, 500f)
    var whatsapp = imagen(this,R.drawable.icono3, 600f, 500f)
    var puntero : imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawColor(fondo)
        facebook.pintar(c)
        whatsapp.pintar(c)
    }//onDraw

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                //Presionar
                if(facebook.estaEnArea(event.x, event.y)){
                    este.setTitle("Tocaste Facebook")
                    puntero = facebook
                }
                if(whatsapp.estaEnArea(event.x, event.y)){
                    este.setTitle("Tocaste WhatsApp")
                    puntero = whatsapp
                }
            }

            MotionEvent.ACTION_MOVE->{
                //Arrastrar
                if(puntero!=null){
                    puntero!!.mover(event.x,event.y)
                }
            }

            MotionEvent.ACTION_UP->{
                //Soltar
                puntero = null
            }
        }//when
        invalidate()
        return true
    }
}