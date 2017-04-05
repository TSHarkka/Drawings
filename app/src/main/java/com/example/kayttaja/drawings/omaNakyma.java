package com.example.kayttaja.drawings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by kayttaja on 05/04/2017.
 */

class omaNakyma extends View {

    public omaNakyma(Context context)
    {
        super(context);
    }

    public omaNakyma(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint piirto_aset = new Paint();

        piirto_aset.setColor(Color.BLUE);
        int y=200;
        int x=600;
        int radius=10;
        for(int i=0; i<5; i++)
        {
            canvas.drawRect(x-radius, y-radius, x+radius, y+radius, piirto_aset);
            y+=2*radius + 10 + 50;
            radius+=10;
        }

        x=200;
        y=200;
        radius = 10;

        piirto_aset.setColor(Color.RED);
        canvas.drawCircle(x,y,radius, piirto_aset);
        for(int i=0; i<5; i++)
        {
            canvas.drawCircle(x,y,radius, piirto_aset);
            y+=2*radius + 10 + 50;
            radius+=10;
        }


        y=800;
        piirto_aset.setColor(Color.GREEN);
        piirto_aset.setStrokeWidth(4);
        canvas.drawLine(x-200, y, x+200, y, piirto_aset);
        canvas.drawLine(x-200, y-300, x-200, y+200, piirto_aset);
    }

    public void siirraOik()
    {

    }
}
