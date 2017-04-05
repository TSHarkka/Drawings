package com.example.kayttaja.drawings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

class omaNakyma extends View {

    public int xKoord=100;
    public int yKoord=800;
    public int muutos=0;

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
        int x=600+muutos;
        int radius=10;
        for(int i=0; i<5; i++)
        {
            canvas.drawRect(x-radius, y-radius, x+radius, y+radius, piirto_aset);
            y+=2*radius + 10 + 50;
            radius+=10;
        }

        x=200+muutos;
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

        canvas.drawCircle(xKoord,yKoord,radius, piirto_aset);
    }

    public void setxKoord(int x) {
        this.xKoord=x;
    }

    public void setMuutos( int x) {
        this.muutos+=x;
    }
    public int getXKoord()
    {
        return xKoord;
    }

}
