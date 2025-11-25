package com.example.kosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    private TextView textLosowanie, textWynikGry, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10;
    private Button buttonRoll;
    private Button buttonReset;

    private ImageView foto1, foto2, foto3, foto4, foto5;

    int[] obrazy = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6};

    int wynikGry = 0, poprzedniaLiczba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textLosowanie = findViewById(R.id.textLosowanie);
        textWynikGry = findViewById(R.id.textWynikGry);
        buttonRoll = findViewById(R.id.buttonRoll);
        buttonReset = findViewById(R.id.buttonReset);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        foto1 = findViewById(R.id.foto1);
        foto2 = findViewById(R.id.foto2);
        foto3 = findViewById(R.id.foto3);
        foto4 = findViewById(R.id.foto4);
        foto5 = findViewById(R.id.foto5);
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView[] pola = {foto1, foto2, foto3, foto4, foto5};
                int[] kosci = new int[5];
                int wynik = 0, para = 0, mStreet = 0, dStreet = 0, full = 0, poker = 0, kareta = 0, trojka = 0, cus = 0;

                for (int i = 0; i < 5; i++) {
                    cus = random.nextInt(6) + 1;
                    for (int a = 0; a < kosci.length; a++){
                        if (cus == kosci[a]){
                            if (para == 0){
                                para = kosci[i] + kosci[a];
                            }
                        }
                    }
                    kosci[i] = cus;
                    pola[i].setImageResource(obrazy[kosci[i] - 1]);
                    wynik += kosci[i];
                    poprzedniaLiczba = kosci[i];
                }
                if (kosci[0] == 1 && kosci[1] == 2 && kosci[2] == 3 && kosci[3] == 4 && kosci[4] == 5){
                    mStreet = 15;
                }
                if (kosci[0] == 2 && kosci[1] == 3 && kosci[2] == 4 && kosci[3] == 5 && kosci[4] == 6){
                    dStreet = 20;
                }

                textLosowanie.setText("Wynik tego losowania: " + wynik);
                wynikGry += wynik;
                textWynikGry.setText("Wynik gry: " + wynikGry);
                textView3.setText("Para: " + para);
                textView4.setText("2 Pary: ");
                textView5.setText("Trójka: " + trojka);
                textView6.setText("Kareta: " + kareta);
                textView7.setText("Poker: " + poker);
                textView8.setText("Full: " + full);
                textView9.setText("m Street: " + mStreet);
                textView10.setText("d Street: " + dStreet);
                para = 0;
                mStreet = 0;
                dStreet = 0;
                full = 0;
                poker = 0;
                kareta = 0;
                trojka = 0;

            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foto1.setImageResource(R.drawable.question);
                foto2.setImageResource(R.drawable.question);
                foto3.setImageResource(R.drawable.question);
                foto4.setImageResource(R.drawable.question);
                foto5.setImageResource(R.drawable.question);

                wynikGry = 0;
                textLosowanie.setText("Wynik tego losowania: 0");
                textWynikGry.setText("Wynik gry: 0");
            }
        });
    }
}
