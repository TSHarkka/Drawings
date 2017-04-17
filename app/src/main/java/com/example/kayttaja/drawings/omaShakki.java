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

        public int ruudunPituus=50;

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
            int x=200;
            int y=200;
            piirto_aset.setStrokeWidth(4);
            piirto_aset.setColor(Color.BLACK);

            for (int i=0; i<10; i++) {
                canvas.drawLine(x, y, x + ruudunPituus*9, y, piirto_aset);
                y+=ruudunPituus;
            }

            x=200;
            y=200;
            for (int i=0; i<10; i++) {
                canvas.drawLine(x, y, x, y + ruudunPituus*9, piirto_aset);
                x+=ruudunPituus;
            }

            for (Point point1 : Shakki.xypist2) {
                canvas.drawCircle(point1.x, point1.y, 10, piirto_aset);
            }

            for (Point kpoint1 : Shakki.keskiPist2) {
                canvas.drawCircle(kpoint1.x, kpoint1.y, 5, piirto_aset);
            }

        }
}
