package com.example.kayttaja.drawings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kayttaja on 11/04/2017.
 */

class omaDiagram extends View {

    public int muutos=0;

    public omaDiagram(Context context)
    {
        super(context);
    }

    // en ole vielä keksinyt tälle käyttöä, vaikka powerpointeissa esiintyikin.
    public omaDiagram(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint piirto_aset = new Paint();

        // Pisteen piitäminen
        for (Point point1 : Diagrammi.xypist2) {
            canvas.drawCircle(point1.x, point1.y, 10, piirto_aset);
        }

    }
}
