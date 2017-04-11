package com.example.kayttaja.drawings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Muodot extends AppCompatActivity {

    omaNakyma gNakyma;
    Button rightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muodot);

        gNakyma = new omaNakyma(this);

        rightBtn = (Button) findViewById(R.id.toRight);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.myDrawing);
        layout.addView(gNakyma, new ViewGroup.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        //setContentView(new omaNakyma(this));
    }

    public void moveRight(View view)
    {
        rightBtn.setText("Painettu");
        //gNakyma.setxKoord(gNakyma.getXKoord()+10);
        gNakyma.setMuutos(20);
        gNakyma.invalidate();
    }

    public void moveLeft(View view)
    {
        rightBtn.setText("Painettu");
        //gNakyma.setxKoord(gNakyma.getXKoord()+10);
        gNakyma.setMuutos(-20);
        gNakyma.invalidate();
    }
}
