package com.example.kayttaja.drawings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kayttaja on 12/04/2017.
 */

class omaShakki extends View {

        public int ruudunPituus=60;

        public omaShakki(Context context)
        {
            super(context);
        }

        // en ole vielä keksinyt tälle käyttöä, vaikka powerpointeissa esiintyikin.
        public omaShakki(Context context, AttributeSet attrs)
        {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint piirto_aset = new Paint();

            // Laudan piirtäminen
            int x=100;
            int y=100;
            piirto_aset.setStrokeWidth(4);
            piirto_aset.setColor(Color.BLACK);

            for (int i=0; i<10; i++) {
                canvas.drawLine(x, y, x + ruudunPituus*9, y, piirto_aset);
                y+=ruudunPituus;
            }

            x=100;
            y=100;
            for (int i=0; i<10; i++) {
                canvas.drawLine(x, y, x, y + ruudunPituus*9, piirto_aset);
                x+=ruudunPituus;
            }

            for (Point point1 : Shakki.xypist2) {
                if (point1.getColor()=="RED") {
                    piirto_aset.setColor(Color.RED);
                    canvas.drawCircle(point1.x, point1.y, 15, piirto_aset);
                } else if (point1.getColor()=="BLUE") {
                    piirto_aset.setColor(Color.BLUE);
                    canvas.drawCircle(point1.x, point1.y, 15, piirto_aset);
                }
            }

            /*for (Point kpoint1 : Shakki.keskiPist2) {
                canvas.drawCircle(kpoint1.x, kpoint1.y, 5, piirto_aset);
            }*/

        }


}

