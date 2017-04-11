package com.example.kayttaja.drawings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Diagrammi extends AppCompatActivity {

    omaDiagram gNakyma;
    Button rightBtn;
    final static ArrayList<Point> xypist2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammi);

        Point point = new Point();
        point.x = 10;
        point.y = 300;
        xypist2.add(point);

        gNakyma = new omaDiagram(this);

        rightBtn = (Button) findViewById(R.id.toRight);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.myDrawing);
        layout.addView(gNakyma, new ViewGroup.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float touchX = event.getX();
        float touchY = event.getY();
        Point point2 = new Point();
        point2.x=Math.round(touchX);
        point2.y=Math.round(touchY)-150;   // lisäsin korjauskertoimen että menee kohdilleen
        xypist2.add(point2);

        // indicate view should be redrawn
        gNakyma.invalidate();
        return true;
    }

    public void moveUp(View view)
    {
        Point point = new Point();
        point.x = xypist2.get(xypist2.size() - 1).getX() + 20;
        point.y = xypist2.get(xypist2.size() - 1).getY() - 20;
        //point.x = xypist2.get(xypist2.size()-1).x + 10;
        //point.y = xypist2.get(xypist2.size()-1).y - 10;

        xypist2.add(point);
        gNakyma.invalidate();
    }

    public void moveDown(View view)
    {
        Point point = new Point();
        point.x = xypist2.get(xypist2.size() - 1).getX() + 20;
        point.y = xypist2.get(xypist2.size() - 1).getY() + 20;

        xypist2.add(point);
        gNakyma.invalidate();
    }

    public void deleteLast(View view)
    {
        for (int x=0; x<xypist2.size();x++)
        {
            xypist2.clear();
            //xypist2.remove(xypist2.size() - 1);
        }

        gNakyma.invalidate();
    }
}