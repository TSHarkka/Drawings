package com.example.kayttaja.drawings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Shakki extends AppCompatActivity {

    omaShakki gNakyma;
    Button rightBtn;
    final static ArrayList<Point> xypist2 = new ArrayList<>();
    final static ArrayList<Point> keskiPist2 = new ArrayList<>();
    static boolean  punNelio=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakki);

        // ruutujen keskipisteet manuaalisesti asetettuna
        // alkupiste laudalle 200, 200, ruudun pituus 50 !! LAUTAA SUURENNETTU
        for ( int i=0; i<9; i++) {
            for ( int j=0; j<9; j++) {
                Point kpoint = new Point();
                kpoint.x = j*50+50/2+200;
                kpoint.y = i*50+50/2+200;
                keskiPist2.add(kpoint);
            }
        }

        gNakyma = new omaShakki(this);

        rightBtn = (Button) findViewById(R.id.toRight);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.myDrawing);
        layout.addView(gNakyma, new ViewGroup.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            float touchX = event.getX();
            float touchY = event.getY();
            Point point2 = new Point();
            point2.x = Math.round(touchX);
            point2.y = Math.round(touchY) - 150;   // lisäsin korjauskertoimen että menee kohdilleen
            if (punNelio) {
                point2.color = "RED";
                punNelio = false;
            } else {
                point2.color = "BLUE";
                punNelio = true;
            }


            xypist2.add(point2);
        }

        /*
        for (Point p : keskiPist2){
            System.out.println("p:     "+p.x +"," + p.y);
            System.out.println("point: "+point2.x+","+point2.y);

            // Jos kosketuspiste on alle 25 etäisyydellä ruudun keskipisteestä piirretään se siihen.
            // MIKSI MENEE ENSIMMÄISEEN RUUTUUN
            double xet =Math.pow(((double)point2.x - (double)p.x), 2);
            System.out.println("xet" + xet);
            double yet =Math.pow(((double)point2.y - (double)p.y), 2);
            System.out.println("yet" + xet);
            double pisteidenEtaisyys =Math.pow(( xet + yet ), 1/2);
            System.out.println(pisteidenEtaisyys);

            if ( pisteidenEtaisyys <= 5 ) {
                System.out.println("alle");
                xypist2.add(p);
                break;
            }

        }*/


        gNakyma.invalidate();

        // laitetaan viive ettei lue kerralla montaa pistettä
        /*try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (Exception e) {
            System.out.println("virhe");
        }*/
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
        for (int x=0; x<xypist2.size();x++)
        {
        xypist2.clear();

        }
        gNakyma.invalidate();
    }

    public void deleteLast(View view)
    {
        //for (int x=0; x<xypist2.size();x++)
        //{
            if(xypist2.size()>0) {
                xypist2.remove(xypist2.size()-1);
            }
        //}

        gNakyma.invalidate();
    }

}
