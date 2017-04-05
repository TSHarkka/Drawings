package com.example.kayttaja.drawings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    omaNakyma gNakyma;
    Button siirraVas;
    Button siirraOik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siirraVas = (Button) findViewById(R.id.toLeft);
        siirraOik = (Button) findViewById(R.id.toRight);

        gNakyma = new omaNakyma(this);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.myDrawing);
        layout.addView(gNakyma, new ViewGroup.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
        //setContentView(new omaNakyma(this));
    }

    public void moveRight() {

    }
}