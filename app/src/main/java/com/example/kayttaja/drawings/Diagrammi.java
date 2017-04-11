package com.example.kayttaja.drawings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        //setContentView(new omaNakyma(this));
    }

    public void moveRight(View view)
    {
        Point point = new Point();
        point.x = xypist2.get(xypist2.size() - 1).getX() + 20;
        point.y = xypist2.get(xypist2.size() - 1).getY() - 20;
        //point.x = xypist2.get(xypist2.size()-1).x + 10;
        //point.y = xypist2.get(xypist2.size()-1).y - 10;

        xypist2.add(point);
        gNakyma.invalidate();
    }

    public void moveLeft(View view)
    {
        Point point = new Point();
        point.x = xypist2.get(xypist2.size() - 1).getX() + 20;
        point.y = xypist2.get(xypist2.size() - 1).getY() + 20;

        xypist2.add(point);
        gNakyma.invalidate();
    }
}